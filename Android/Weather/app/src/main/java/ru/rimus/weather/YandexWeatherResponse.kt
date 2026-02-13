package ru.rimus.weather

import com.google.gson.annotations.SerializedName

data class YandexWeatherResponse(
    @SerializedName("now") val now: Long,
    @SerializedName("now_dt") val nowDt: String,
    @SerializedName("info") val info: Info,
    @SerializedName("fact") val fact: Fact,
    @SerializedName("forecast") val forecast: Forecast
)

data class Info(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("tzinfo") val tzinfo: TzInfo
)

data class TzInfo(
    @SerializedName("name") val name: String,
    @SerializedName("offset") val offset: Int
)

data class Fact(
    @SerializedName("temp") val temp: Int,
    @SerializedName("feels_like") val feelsLike: Int,
    @SerializedName("condition") val condition: String,
    @SerializedName("wind_speed") val windSpeed: Double,
    @SerializedName("wind_gust") val windGust: Double,
    @SerializedName("wind_dir") val windDir: String,
    @SerializedName("pressure_mm") val pressureMm: Int,
    @SerializedName("pressure_pa") val pressurePa: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("season") val season: String,
    @SerializedName("prec_type") val precType: Int,
    @SerializedName("prec_strength") val precStrength: Int,
    @SerializedName("cloudness") val cloudness: Double,
    @SerializedName("daytime") val daytime: String,
    @SerializedName("polar") val polar: Boolean,
    @SerializedName("icon") val icon: String
)

data class Forecast(
    @SerializedName("date") val date: String,
    @SerializedName("date_ts") val dateTs: Long,
    @SerializedName("week") val week: Int,
    @SerializedName("parts") val parts: Parts
)

data class Parts(
    @SerializedName("day") val day: Part?,
    @SerializedName("night") val night: Part?,
    @SerializedName("morning") val morning: Part?,
    @SerializedName("evening") val evening: Part?
)

data class Part(
    @SerializedName("temp_min") val tempMin: Int?,
    @SerializedName("temp_max") val tempMax: Int?,
    @SerializedName("temp_avg") val tempAvg: Int?,
    @SerializedName("feels_like") val feelsLike: Int?,
    @SerializedName("condition") val condition: String?,
    @SerializedName("wind_speed") val windSpeed: Double?,
    @SerializedName("wind_gust") val windGust: Double?,
    @SerializedName("wind_dir") val windDir: String?,
    @SerializedName("pressure_mm") val pressureMm: Int?,
    @SerializedName("humidity") val humidity: Int?,
    @SerializedName("prec_mm") val precMm: Int?,
    @SerializedName("prec_period") val precPeriod: Int?,
    @SerializedName("prec_prob") val precProb: Int?
)

sealed class WeatherState {
    object Loading : WeatherState()
    data class Success(val weatherData: YandexWeatherResponse) : WeatherState()
    data class Error(val message: String) : WeatherState()
}
