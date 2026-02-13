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
 * ФУНКЦИЯ 1: Отправляет GET запрос к Яндекс.Погоде и возвращает JSON
 */
suspend fun fetchYandexWeatherJson(
    context: Context,
    lat: Double,
    lon: Double,
    apiKey: String
): JSONObject = suspendCancellableCoroutine { continuation ->

    val url = "https://api.weather.yandex.ru/v2/forecast?lat=$lat&lon=$lon&lang=ru_RU&limit=5&hours=true"

    val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    val jsonObjectRequest = object : JsonObjectRequest(
        Request.Method.GET, url, null,
        { response ->
            continuation.resume(response)
            requestQueue.stop()
        },
        { error ->
            continuation.resumeWithException(Exception(error.message ?: "Ошибка запроса"))
            requestQueue.stop()
        }
    ) {
        override fun getHeaders(): MutableMap<String, String> {
            val headers = HashMap<String, String>()
            headers["X-Yandex-API-Key"] = apiKey
            return headers
        }
    }

    requestQueue.add(jsonObjectRequest)

    continuation.invokeOnCancellation {
        requestQueue.cancelAll { true }
        requestQueue.stop()
    }
}