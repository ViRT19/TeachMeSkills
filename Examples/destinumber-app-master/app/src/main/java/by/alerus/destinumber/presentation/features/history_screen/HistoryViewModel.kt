package by.alerus.destinumber.presentation.features.history_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.alerus.destinumber.data.api.PredictionsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val predictionsApi: PredictionsApi
) : ViewModel() {

    private val _state = MutableStateFlow<HistoryUiState>(HistoryUiState.Loading)
    val state: StateFlow<HistoryUiState> = _state

    init {
        loadPredictions()
    }

    fun loadPredictions() {
        viewModelScope.launch {
            _state.value = HistoryUiState.Loading
            try {
                val list = predictionsApi.predictionsRetrieve()
                _state.value = HistoryUiState.Success(predictions = list)
            } catch (e: Exception) {
                Log.e("HistoryViewModel", "Failed to load predictions", e)
                _state.value = HistoryUiState.Error(message = e.message ?: "Unknown error")
            }
        }
    }
} 