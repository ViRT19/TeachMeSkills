package by.alerus.destinumber.presentation.features.profile_screen

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

class ProfileViewModel : ViewModel(), KoinComponent {
    private val apiRepository: ApiRepository by inject()
    
    var uiState by mutableStateOf(ProfileUiState())
        private set

    fun loadProfile(loadFailMessage: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val result = withContext(Dispatchers.IO) {
                    apiRepository.getUserProfile()
                }
                
                result.onSuccess { profile ->
                    uiState = uiState.copy(
                        profile = profile,
                        editedProfile = profile,
                        isLoading = false
                    )
                }.onFailure { exception ->
                    Log.e("ProfileViewModel", "Failed to load profile", exception)
                    uiState = uiState.copy(
                        error = loadFailMessage,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Exception loading profile", e)
                uiState = uiState.copy(
                    error = loadFailMessage,
                    isLoading = false
                )
            }
        }
    }

    fun startEditing() {
        uiState = uiState.copy(isEditing = true)
    }

    fun cancelEditing() {
        uiState = uiState.copy(
            isEditing = false,
            editedProfile = uiState.profile,
            error = null,
            successMessage = null
        )
    }

    fun updateField(field: String, value: String) {
        val currentEdited = uiState.editedProfile ?: return
        val updatedProfile = when (field) {
            "username" -> currentEdited.copy(username = value)
            "email" -> currentEdited.copy(email = value.ifBlank { null })
            "firstName" -> currentEdited.copy(firstName = value.ifBlank { null })
            "lastName" -> currentEdited.copy(lastName = value.ifBlank { null })
            else -> currentEdited
        }
        uiState = uiState.copy(editedProfile = updatedProfile)
    }

    fun updateDateOfBirth(date: java.time.LocalDate?) {
        val currentEdited = uiState.editedProfile ?: return
        val updatedProfile = currentEdited.copy(dateOfBirth = date)
        uiState = uiState.copy(editedProfile = updatedProfile)
    }

    fun saveProfile(successMessage: String, errorMessage: String) {
        val editedProfile = uiState.editedProfile ?: return

        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val result = withContext(Dispatchers.IO) {
                    apiRepository.updateUserProfile(editedProfile)
                }
                
                result.onSuccess { updatedProfile ->
                    uiState = uiState.copy(
                        profile = updatedProfile,
                        editedProfile = updatedProfile,
                        isEditing = false,
                        isLoading = false,
                        successMessage = successMessage
                    )
                }.onFailure { exception ->
                    Log.e("ProfileViewModel", "Failed to update profile", exception)
                    uiState = uiState.copy(
                        error = errorMessage,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Exception updating profile", e)
                uiState = uiState.copy(
                    error = errorMessage,
                    isLoading = false
                )
            }
        }
    }

    fun clearError() {
        uiState = uiState.copy(error = null)
    }

    fun clearSuccessMessage() {
        uiState = uiState.copy(successMessage = null)
    }
} 