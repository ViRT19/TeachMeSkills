package by.alerus.destinumber.presentation.features.history_screen

import by.alerus.destinumber.data.model.PredictionAct

sealed class HistoryUiState {
    data object Loading : HistoryUiState()
    data class Success(val predictions: List<PredictionAct>) : HistoryUiState()
    data class Error(val message: String) : HistoryUiState()
} 