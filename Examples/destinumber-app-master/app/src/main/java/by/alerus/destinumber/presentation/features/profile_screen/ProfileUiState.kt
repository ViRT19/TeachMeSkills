package by.alerus.destinumber.presentation.features.profile_screen

import by.alerus.destinumber.data.model.UserProfile

data class ProfileUiState(
    val profile: UserProfile? = null,
    val isLoading: Boolean = false,
    val isEditing: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null,
    val editedProfile: UserProfile? = null
) 