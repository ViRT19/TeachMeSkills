package by.alerus.destinumber.presentation.features.login_screen

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val loginError: String? = null
) 