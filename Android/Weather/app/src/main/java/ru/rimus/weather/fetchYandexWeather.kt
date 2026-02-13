package ru.rimus.weather

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * ФУНКЦИЯ 1: Запрос к API Яндекс.Погоды
 * @param context Контекст приложения для Volley
 * @param lat Широта
 * @param lon Долгота
 * @param apiKey API ключ Яндекс.Погоды
 * @param lang Язык ответа (ru_RU по умолчанию)
 * @param limit Количество дней прогноза
 * @param hours Включить почасовой прогноз
 * @return JSONObject с данными погоды
 */
suspend fun fetchYandexWeather(
    context: Context,
    lat: Double,
    lon: Double,
    apiKey: String,
    lang: String = "ru_RU",
    limit: Int = 5,
    hours: Boolean = true
): JSONObject = suspendCancellableCoroutine { continuation ->

    // Формируем URL с параметрами
    val url = "https://api.weather.yandex.ru/v2/forecast?" +
            "lat=$lat&lon=$lon&lang=$lang&limit=$limit&hours=$hours"

    val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    val jsonObjectRequest = object : JsonObjectRequest(
        Request.Method.GET, url, null,
        { response ->
            // Успешный ответ
            continuation.resume(response)
            requestQueue.stop()
        },
        { error ->
            // Обработка ошибки
            val errorMessage = when {
                error.networkResponse != null -> {
                    val statusCode = error.networkResponse.statusCode
                    val errorBody = String(error.networkResponse.data)
                    "Ошибка $statusCode: $errorBody"
                }
                error.message != null -> error.message!!
                else -> "Неизвестная ошибка при запросе к Яндекс.Погоде"
            }
            continuation.resumeWithException(Exception(errorMessage))
            requestQueue.stop()
        }
    ) {
        override fun getHeaders(): MutableMap<String, String> {
            val headers = HashMap<String, String>()
            headers["X-Yandex-API-Key"] = apiKey
            headers["Accept"] = "application/json"
            return headers
        }
    }

    // Настройка таймаута
    jsonObjectRequest.retryPolicy = com.android.volley.DefaultRetryPolicy(
        15000, // 15 секунд таймаут
        1,     // 1 повторная попытка
        1.0f   // множитель задержки
    )

    // Добавляем запрос в очередь
    requestQueue.add(jsonObjectRequest)

    // Отмена запроса при отмене корутины
    continuation.invokeOnCancellation {
        requestQueue.cancelAll { true }
        requestQueue.stop()
    }
}

/**
 * Альтернативная версия с callback (без корутин)
 */
fun fetchYandexWeatherCallback(
    context: Context,
    lat: Double,
    lon: Double,
    apiKey: String,
    onSuccess: (JSONObject) -> Unit,
    onError: (String) -> Unit,
    lang: String = "ru_RU",
    limit: Int = 5
) {
    val url = "https://api.weather.yandex.ru/v2/forecast?" +
            "lat=$lat&lon=$lon&lang=$lang&limit=$limit"

    val requestQueue = Volley.newRequestQueue(context)

    val jsonObjectRequest = object : JsonObjectRequest(
        Request.Method.GET, url, null,
        { response -> onSuccess(response) },
        { error ->
            val errorMessage = error.message ?: "Неизвестная ошибка"
            onError(errorMessage)
        }
    ) {
        override fun getHeaders(): MutableMap<String, String> {
            val headers = HashMap<String, String>()
            headers["X-Yandex-API-Key"] = apiKey
            return headers
        }
    }

    requestQueue.add(jsonObjectRequest)
}