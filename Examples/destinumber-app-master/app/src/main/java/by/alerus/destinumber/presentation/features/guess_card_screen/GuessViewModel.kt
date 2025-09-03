package by.alerus.destinumber.presentation.features.guess_card_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.alerus.destinumber.data.api.PredictionsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class GuessViewModel(
    private val predictionsApi: PredictionsApi
) : ViewModel() {

    private val _state = MutableStateFlow(GuessState())
    val state: StateFlow<GuessState> = _state

    fun onDateSelected(date: Date) {
        _state.value = _state.value.copy(selectedDate = date)
    }

    fun onCardSelected(cardNumber: Int) {
        _state.value = _state.value.copy(selectedDestinyCard = cardNumber)
        makePrediction()
    }

    private fun makePrediction() {
        viewModelScope.launch {
            _state.value = _state.value.copy(uiState = GuessUiState.Loading)
            try {
                val request = mapOf(
                    "prediction_num" to _state.value.selectedDestinyCard,
                    "date" to SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(_state.value.selectedDate)
                )
                val prediction = predictionsApi.predictionsCreate(request)
                _state.value = _state.value.copy(uiState = GuessUiState.Success(prediction.prediction.text))
            } catch (e: Exception) {
                _state.value = _state.value.copy(uiState = GuessUiState.Error(e.message ?: "Unknown error"))
                Log.e("GuessViewModel", "Error making prediction", e)
            }
        }
    }
} 