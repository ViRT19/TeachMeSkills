package by.alerus.destinumber.presentation.features.registration_screen

import by.alerus.destinumber.data.model.UserRegistration
import java.time.LocalDate

data class RegistrationUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: LocalDate? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null,
    val isUsernameValid: Boolean = true,
    val isEmailValid: Boolean = true,
    val isPasswordValid: Boolean = true,
    val isConfirmPasswordValid: Boolean = true
) {
    fun toUserRegistration(): UserRegistration = UserRegistration(
        username = username,
        email = email.ifBlank { null },
        password = password,
        firstName = firstName.ifBlank { null },
        lastName = lastName.ifBlank { null },
        dateOfBirth = dateOfBirth
    )
} 