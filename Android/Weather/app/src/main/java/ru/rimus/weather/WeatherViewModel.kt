package ru.rimus.weather

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _weatherState = mutableStateOf<WeatherState>(WeatherState.Loading)
    val weatherState: State<WeatherState> = _weatherState

    private val _cityName = mutableStateOf("Санкт-Петербург")
    val cityName: State<String> = _cityName

    private val gson = Gson()

    /**
     * ФУНКЦИЯ 2: Получение JSON и обновление UI
     * @param context Контекст приложения
     * @param apiKey API ключ Яндекс.Погоды
     * @param lat Широта
     * @param lon Долгота
     * @param city Название города для отображения
     */
    fun getWeatherAndUpdateUI(
        context: Context,
        apiKey: String,
        lat: Double = 59.9343,  // Санкт-Петербург по умолчанию
        lon: Double = 30.3351,
        city: String = "Санкт-Петербург"
    ) {
        viewModelScope.launch {
            _weatherState.value = WeatherState.Loading
            _cityName.value = city

            try {
                // Вызываем ФУНКЦИЮ 1 для получения JSON
                val jsonResponse = fetchYandexWeather(
                    context = context,
                    lat = lat,
                    lon = lon,
                    apiKey = apiKey,
                    lang = "ru_RU",
                    limit = 3
                )

                // Парсим JSON в объект данных
                val weatherData = gson.fromJson(
                    jsonResponse.toString(),
                    YandexWeatherResponse::class.java
                )

                // Обновляем состояние UI
                _weatherState.value = WeatherState.Success(weatherData)

            } catch (e: Exception) {
                _weatherState.value = WeatherState.Error(
                    e.message ?: "Не удалось загрузить погоду"
                )
            }
        }
    }
}

@Composable
fun YandexWeatherScreen(
    viewModel: WeatherViewModel = viewModel(),
    apiKey: String
) {
    val context = LocalContext.current
    val weatherState by remember { viewModel.weatherState }
    val cityName by remember { viewModel.cityName }

    // Загружаем погоду при первом запуске
    LaunchedEffect(Unit) {
        viewModel.getWeatherAndUpdateUI(context, apiKey)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Погода: $cityName")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                actions = {
                    IconButton(onClick = {
                        viewModel.getWeatherAndUpdateUI(context, apiKey)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Обновить"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        when (val state = weatherState) {
            is WeatherState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colors.primary,
                            strokeWidth = 3.dp,
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Загрузка данных о погоде...",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            is WeatherState.Success -> {
                WeatherContent(
                    weatherData = state.weatherData,
                    modifier = Modifier.padding(paddingValues)
                )
            }

            is WeatherState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color.Red,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Ошибка загрузки",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = state.message,
                            fontSize = 16.sp,
                            color = Color.Gray,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Button(
                            onClick = {
                                viewModel.getWeatherAndUpdateUI(context, apiKey)
                            }
                        ) {
                            Text("Повторить")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherContent(
    weatherData: YandexWeatherResponse,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Текущая погода
        item {
            CurrentWeatherCard(weatherData.fact)
        }

        // Прогноз по частям дня
        item {
            Text(
                text = "Прогноз на сегодня",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        weatherData.forecast.parts.let { parts ->
            item { PartWeatherCard("Утро", parts.morning) }
            item { PartWeatherCard("День", parts.day) }
            item { PartWeatherCard("Вечер", parts.evening) }
            item { PartWeatherCard("Ночь", parts.night) }
        }

        // Прогноз на ближайшие дни
        item {
            Text(
                text = "Прогноз на неделю",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun CurrentWeatherCard(fact: Fact) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.1f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${fact.temp}°C",
                fontSize = 56.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )

            Text(
                text = getConditionText(fact.condition),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )

            Text(
                text = "Ощущается как ${fact.feelsLike}°C",
                fontSize = 18.sp,
                color = Color.Gray
            )

            Divider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherDetailItem(
                    label = "Ветер",
                    value = "${fact.windSpeed} м/с",
                    icon = null
                )
                WeatherDetailItem(
                    label = "Давление",
                    value = "${fact.pressureMm} мм",
                    icon = null
                )
                WeatherDetailItem(
                    label = "Влажность",
                    value = "${fact.humidity}%",
                    icon = null
                )
            }
        }
    }
}

@Composable
fun PartWeatherCard(
    partName: String,
    part: Part?
) {
    if (part != null) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 2.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = partName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = getConditionText(part.condition ?: ""),
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${part.tempAvg ?: 0}°C",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "мин: ${part.tempMin ?: 0}°",
                            fontSize = 12.sp,
                            color = Color.Blue.copy(alpha = 0.7f)
                        )
                        Text(
                            text = "макс: ${part.tempMax ?: 0}°",
                            fontSize = 12.sp,
                            color = Color.Red.copy(alpha = 0.7f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherDetailItem(
    label: String,
    value: String,
    icon: Painter?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

fun getConditionText(condition: String): String {
    return when (condition) {
        "clear" -> "Ясно"
        "partly-cloudy" -> "Малооблачно"
        "cloudy" -> "Облачно"
        "overcast" -> "Пасмурно"
        "drizzle" -> "Морось"
        "light-rain" -> "Небольшой дождь"
        "rain" -> "Дождь"
        "moderate-rain" -> "Умеренный дождь"
        "heavy-rain" -> "Сильный дождь"
        "continuous-heavy-rain" -> "Длительный сильный дождь"
        "showers" -> "Ливень"
        "wet-snow" -> "Дождь со снегом"
        "light-snow" -> "Небольшой снег"
        "snow" -> "Снег"
        "snow-showers" -> "Снегопад"
        "hail" -> "Град"
        "thunderstorm" -> "Гроза"
        "thunderstorm-with-rain" -> "Гроза с дождем"
        "thunderstorm-with-hail" -> "Гроза с градом"
        else -> condition
    }
}