package ru.rimus.weather

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

class WeatherJsonViewModel : ViewModel() {
    var jsonResponse by mutableStateOf<String?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    /**
     * ФУНКЦИЯ 2: Получает JSON и обновляет UI
     */
    fun fetchAndDisplayJson(context: Context, apiKey: String) {
        viewModelScope.launch {
            isLoading = true
            error = null

            try {
                val json = fetchYandexWeatherJson(
                    context = context,
                    lat = 59.9343,
                    lon = 30.3351,
                    apiKey = apiKey
                )
                jsonResponse = json.toString(2) // с отступами для читаемости
            } catch (e: Exception) {
                error = e.message ?: "Неизвестная ошибка"
                jsonResponse = null
            } finally {
                isLoading = false
            }
        }
    }
}

@Composable
fun YandexWeatherJsonScreen(
    viewModel: WeatherJsonViewModel = viewModel(),
    apiKey: String
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.fetchAndDisplayJson(context, apiKey)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Кнопка обновления
            Button(
                onClick = { viewModel.fetchAndDisplayJson(context, apiKey) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Обновить JSON")
            }

            // Отображение JSON или состояния
            Box(modifier = Modifier.fillMaxSize()) {
                when {
                    viewModel.isLoading -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                    viewModel.error != null -> {
                        Text(
                            text = "Ошибка: ${viewModel.error}",
                            color = MaterialTheme.colors.error,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    viewModel.jsonResponse != null -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp)
                        ) {
                            item {
                                Text(
                                    text = viewModel.jsonResponse!!,
                                    fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                                    fontSize = MaterialTheme.typography.body2.fontSize
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}