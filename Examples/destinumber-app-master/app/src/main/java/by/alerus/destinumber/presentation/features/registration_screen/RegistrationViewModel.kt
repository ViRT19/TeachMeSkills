package by.alerus.destinumber.presentation.features.registration_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.alerus.destinumber.data.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.regex.Pattern

class RegistrationViewModel : ViewModel(), KoinComponent {
    private val apiRepository: ApiRepository by inject()
    
    var uiState by mutableStateOf(RegistrationUiState())
        private set

    private val usernamePattern = Pattern.compile("^[\\w.@+-]+$")
    private val emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

    fun onUsernameChange(username: String) {
        val isValid = username.isEmpty() || usernamePattern.matcher(username).matches()
        uiState = uiState.copy(
            username = username,
            isUsernameValid = isValid,
            error = null
        )
    }

    fun onEmailChange(email: String) {
        val isValid = email.isEmpty() || emailPattern.matcher(email).matches()
        uiState = uiState.copy(
            email = email,
            isEmailValid = isValid,
            error = null
        )
    }

    fun onPasswordChange(password: String) {
        val isValid = password.isNotEmpty()
        uiState = uiState.copy(
            password = password,
            isPasswordValid = isValid,
            error = null
        )
        validateConfirmPassword()
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        uiState = uiState.copy(
            confirmPassword = confirmPassword,
            error = null
        )
        validateConfirmPassword()
    }

    fun onFirstNameChange(firstName: String) {
        uiState = uiState.copy(
            firstName = firstName,
            error = null
        )
    }

    fun onLastNameChange(lastName: String) {
        uiState = uiState.copy(
            lastName = lastName,
            error = null
        )
    }

    fun onDateOfBirthChange(date: java.time.LocalDate?) {
        uiState = uiState.copy(
            dateOfBirth = date,
            error = null
        )
    }

    private fun validateConfirmPassword() {
        val isValid = uiState.confirmPassword.isEmpty() || uiState.confirmPassword == uiState.password
        uiState = uiState.copy(isConfirmPasswordValid = isValid)
    }

    fun register(
        onSuccess: () -> Unit,
        errorMessageGeneric: String,
        errorMessageWithReason: String
    ) {
        if (!validateForm(errorMessageGeneric, errorMessageWithReason)) {
            return
        }

        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val result = withContext(Dispatchers.IO) {
                    apiRepository.registerWithoutAuth(
                        username = uiState.username,
                        email = uiState.email,
                        password = uiState.password,
                        firstName = uiState.firstName.ifBlank { null },
                        lastName = uiState.lastName.ifBlank { null },
                        dateOfBirth = uiState.dateOfBirth
                    )
                }
                
                result.onSuccess { userRegistration ->
                    Log.d("RegistrationViewModel", "Registration successful for user: ${userRegistration.username}")
                    uiState = uiState.copy(
                        isLoading = false,
                        successMessage = "Registration successful!"
                    )
                    onSuccess()
                }.onFailure { exception ->
                    Log.e("RegistrationViewModel", "Registration failed", exception)
                    uiState = uiState.copy(
                        error = String.format(errorMessageWithReason, exception.message ?: ""),
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Log.e("RegistrationViewModel", "Exception during registration", e)
                uiState = uiState.copy(
                    error = String.format(errorMessageWithReason, e.message ?: ""),
                    isLoading = false
                )
            }
        }
    }

    private fun validateForm(
        errorMessageGeneric: String,
        errorMessageWithReason: String
    ): Boolean {
        var isValid = true
        
        if (uiState.username.isBlank()) {
            uiState = uiState.copy(
                isUsernameValid = false,
                error = "Username is required"
            )
            isValid = false
        } else if (!usernamePattern.matcher(uiState.username).matches()) {
            uiState = uiState.copy(
                isUsernameValid = false,
                error = "Username can only contain letters, numbers, and @/./+/-/_ characters"
            )
            isValid = false
        }

        if (uiState.password.isBlank()) {
            uiState = uiState.copy(
                isPasswordValid = false,
                error = "Password is required"
            )
            isValid = false
        }

        if (uiState.confirmPassword != uiState.password) {
            uiState = uiState.copy(
                isConfirmPasswordValid = false,
                error = "Passwords do not match"
            )
            isValid = false
        }

        if (uiState.email.isNotBlank() && !emailPattern.matcher(uiState.email).matches()) {
            uiState = uiState.copy(
                isEmailValid = false,
                error = "Invalid email format"
            )
            isValid = false
        }

        return isValid
    }

    fun clearError() {
        uiState = uiState.copy(error = null)
    }

    fun clearSuccessMessage() {
        uiState = uiState.copy(successMessage = null)
    }
} 