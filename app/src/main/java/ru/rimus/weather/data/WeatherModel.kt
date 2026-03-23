package ru.rimus.weather.data

data class WeatherModel(
    val city: String,
    val region: String,
    val country: String,
    val time: String,
    val currentTemp: String,
    val condition: String,
    val icon: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String
)
