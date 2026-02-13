package ru.rimus.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    // ВАЖНО: Получите свой API ключ на https://developer.tech.yandex.ru/
    // Бесплатный лимит: 50 запросов в день
    private val YANDEX_WEATHER_API_KEY = "123e4567-e89b-12d3-a456-426614174000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    YandexWeatherScreen(
                        apiKey = YANDEX_WEATHER_API_KEY
                    )
                }
            }
        }
    }
}