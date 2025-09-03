package by.alerus.destinumber.presentation.features.guess_card_screen

import java.util.Date

sealed class GuessUiState {
    object Loading : GuessUiState()
    data class Success(val prediction: String) : GuessUiState()
    data class Error(val message: String) : GuessUiState()
    object Nothing: GuessUiState()
}

data class GuessState(
    val selectedDate: Date = Date(),
    val selectedDestinyCard: Int? = null,
    val uiState: GuessUiState = GuessUiState.Nothing
) 