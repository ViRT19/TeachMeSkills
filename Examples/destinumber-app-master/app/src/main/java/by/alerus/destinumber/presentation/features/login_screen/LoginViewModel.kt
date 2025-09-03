package by.alerus.destinumber.presentation.features.login_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.alerus.destinumber.data.api.AuthApi
import by.alerus.destinumber.data.model.CustomTokenObtainPair
import by.alerus.destinumber.data.network.TokenStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val authApi: AuthApi,
    private val tokenStorage: TokenStorage
) : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onUsernameChange(username: String) {
        uiState = uiState.copy(username = username, loginError = null)
    }

    fun onPasswordChange(password: String) {
        uiState = uiState.copy(password = password, loginError = null)
    }

    fun login(onSuccess: () -> Unit) {
        Log.d("LoginViewModel", "Login attempt")

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    authApi.authLoginCreate(
                        CustomTokenObtainPair(
                            uiState.username,
                            uiState.password
                        )
                    )
                }
                tokenStorage.saveTokens(response.access, response.refresh)
                onSuccess()
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Login failed", e)
                uiState = uiState.copy(loginError = "Invalid username or password")
            }
        }
    }
} 