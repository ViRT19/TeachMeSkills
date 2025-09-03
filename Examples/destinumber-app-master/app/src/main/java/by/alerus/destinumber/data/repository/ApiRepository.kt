package by.alerus.destinumber.data.repository

import by.alerus.destinumber.data.api.AuthApi
import by.alerus.destinumber.data.api.DefaultApi
import by.alerus.destinumber.data.api.PredictionsApi
import by.alerus.destinumber.data.api.UserApi
import by.alerus.destinumber.data.model.CustomTokenObtainPair
import by.alerus.destinumber.data.model.PatchedUserProfile
import by.alerus.destinumber.data.model.Prediction
import by.alerus.destinumber.data.model.PredictionAct
import by.alerus.destinumber.data.model.PredictionTypeEnum
import by.alerus.destinumber.data.model.TokenRefreshRequest
import by.alerus.destinumber.data.model.TokenResponse
import by.alerus.destinumber.data.model.UserProfile
import by.alerus.destinumber.data.model.UserRegistration
import by.alerus.destinumber.data.model.HealthcheckRetrieve200Response
import by.alerus.destinumber.data.network.TokenStorage

/**
 * Repository that wraps the generated OpenAPI client (OkHttp + coroutines).
 * All methods are suspend and return Result<T> for simple error handling.
 */
class ApiRepository(
    private val authApi: AuthApi,
    private val predictionsApi: PredictionsApi,
    private val defaultApi: DefaultApi,
    private val userApi: UserApi,
    private val tokenStorage: TokenStorage
) {

    // MARK: - Authentication

    suspend fun login(username: String, password: String): Result<TokenResponse> =
        runCatching {
            val response = authApi.authLoginCreate(CustomTokenObtainPair(username, password))
            tokenStorage.saveTokens(response.access, response.refresh)
            response
        }

    suspend fun register(
        username: String,
        email: String,
        password: String
    ): Result<UserRegistration> = runCatching {
        authApi.authRegisterCreate(
            UserRegistration(
                username = username,
                email = email,
                password = password
            )
        )
    }

    suspend fun registerWithoutAuth(
        username: String,
        email: String,
        password: String,
        firstName: String? = null,
        lastName: String? = null,
        dateOfBirth: java.time.LocalDate? = null
    ): Result<UserRegistration> = runCatching {
        // Create the user registration object
        val userRegistration = UserRegistration(
            username = username,
            email = email,
            password = password,
            firstName = firstName,
            lastName = lastName,
            dateOfBirth = dateOfBirth
        )
        
        // The generated client incorrectly requires authentication for registration
        // We'll temporarily clear the token and then restore it
        val currentAccessToken = tokenStorage.getAccessToken()
        val currentRefreshToken = tokenStorage.getRefreshToken()
        
        try {
            // Temporarily clear tokens to bypass auth requirement
            tokenStorage.clearTokens()
            
            // Use the generated client
            authApi.authRegisterCreate(userRegistration)
        } finally {
            // Restore the original tokens
            if (currentAccessToken != null && currentRefreshToken != null) {
                tokenStorage.saveTokens(currentAccessToken, currentRefreshToken)
            }
        }
    }

    suspend fun refreshToken(refreshToken: String): Result<TokenResponse> = runCatching {
        val response = authApi.authRefreshCreate(TokenRefreshRequest(refresh = refreshToken, access = ""))
        tokenStorage.saveTokens(response.access, refreshToken)
        response
    }

    // MARK: - User profile

    suspend fun getUserProfile(): Result<UserProfile> = runCatching {
        userApi.authProfileRetrieve()
    }

    suspend fun updateUserProfile(userProfile: UserProfile): Result<UserProfile> = runCatching {
        userApi.authProfileUpdateUpdate(userProfile)
    }

    suspend fun partialUpdateUserProfile(patchedUserProfile: PatchedUserProfile): Result<UserProfile> = runCatching {
        userApi.authProfileUpdatePartialUpdate(patchedUserProfile)
    }

    // MARK: - Predictions

    suspend fun createPrediction(prediction: Prediction): Result<PredictionAct> = runCatching {
        predictionsApi.predictionsCreate(prediction)
    }

    suspend fun createPrediction(
        text: String,
        predictionType: PredictionTypeEnum
    ): Result<PredictionAct> = runCatching {
        predictionsApi.predictionsCreate(
            Prediction(
                text = text,
                predictionType = predictionType
            )
        )
    }

    suspend fun getUserPredictions(): Result<List<PredictionAct>> = runCatching {
        predictionsApi.predictionsRetrieve()
    }

    // MARK: - Healthcheck

    suspend fun healthCheck(): Result<HealthcheckRetrieve200Response> = runCatching {
        defaultApi.healthcheckRetrieve()
    }

    // MARK: - Utility

    fun setBearerToken(token: String) {
        val currentRefresh = tokenStorage.getRefreshToken()
        if (currentRefresh != null) {
            tokenStorage.saveTokens(token, currentRefresh)
        } else {
            // Save only access; refresh unknown
            tokenStorage.saveTokens(token, "")
        }
    }

    fun clearBearerToken() {
        tokenStorage.clearTokens()
    }

    fun setLogging(enabled: Boolean) {
        // Logging is controlled by OkHttp interceptor in DI. No-op here.
    }
} 