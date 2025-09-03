package by.alerus.destinumber.di

import by.alerus.destinumber.data.api.AuthApi
import by.alerus.destinumber.data.api.DefaultApi
import by.alerus.destinumber.data.api.PredictionsApi
import by.alerus.destinumber.data.api.UserApi
import by.alerus.destinumber.data.model.TokenRefreshRequest
import by.alerus.destinumber.data.network.TokenStorage
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.TimeZone
import okhttp3.logging.HttpLoggingInterceptor

const val AUTH_CLIENT = "authClient"
const val REFRESH_CLIENT = "refreshClient"
const val REFRESH_API = "refreshApi"

const val BASE_URL = "https://bipbop.space/apps/destinumber/"

val networkModule = module {
    single<okhttp3.Call.Factory>(named(AUTH_CLIENT)) {
        OkHttpClient.Builder()
            .addInterceptor(createTimezoneInterceptor())
            .addInterceptor(createAuthInterceptor(get()))
            .addInterceptor(createLoggingInterceptor())
            .authenticator(createTokenAuthenticator(get(), get(named(REFRESH_API))))
            .build()
    }

    single<okhttp3.Call.Factory>(named(REFRESH_CLIENT)) {
        OkHttpClient.Builder()
            .addInterceptor(createTimezoneInterceptor())
            .addInterceptor(createLoggingInterceptor())
            .build()
    }

    single { AuthApi(basePath = BASE_URL, client = get(named(AUTH_CLIENT))) }
    single { PredictionsApi(basePath = BASE_URL, client = get(named(AUTH_CLIENT))) }
    single { DefaultApi(basePath = BASE_URL, client = get(named(AUTH_CLIENT))) }
    single { UserApi(basePath = BASE_URL, client = get(named(AUTH_CLIENT))) }

    single(named(REFRESH_API)) {
        AuthApi(basePath = BASE_URL, client = get(named(REFRESH_CLIENT)))
    }
}

private fun createAuthInterceptor(tokenStorage: TokenStorage): Interceptor {
    return Interceptor { chain ->
        val request = chain.request().newBuilder()
        tokenStorage.getAccessToken()?.let { token ->
            request.addHeader("Authorization", "Bearer $token")
        }
        chain.proceed(request.build())
    }
}

private fun createTimezoneInterceptor(): Interceptor {
    return Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-Timezone", TimeZone.getDefault().id)
            .build()
        chain.proceed(request)
    }
}

private fun createLoggingInterceptor(): Interceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private fun createTokenAuthenticator(
    tokenStorage: TokenStorage,
    authApi: AuthApi
): okhttp3.Authenticator {
    return object : okhttp3.Authenticator {
        override fun authenticate(route: okhttp3.Route?, response: okhttp3.Response): okhttp3.Request? {
            val refreshToken = tokenStorage.getRefreshToken() ?: return null

            return runBlocking {
                try {
                    val refreshResponse = authApi.authRefreshCreate(TokenRefreshRequest(refresh = refreshToken, access = ""))
                    tokenStorage.saveTokens(refreshResponse.access, refreshToken)

                    response.request.newBuilder()
                        .header("Authorization", "Bearer ${refreshResponse.access}")
                        .build()
                } catch (e: Exception) {
                    tokenStorage.clearTokens()
                    null
                }
            }
        }
    }
} 