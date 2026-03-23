package ru.rimus.weather

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import ru.rimus.weather.data.WeatherModel
import ru.rimus.weather.screens.DialogSearch
import ru.rimus.weather.screens.MainCard
import ru.rimus.weather.screens.TabLayout
import ru.rimus.weather.screens.Utils.showTemp
import ru.rimus.weather.ui.theme.WeatherTheme

var apiKey = ""
var cityName = ""

fun GetSettingsData(context: Context) {
    val setting = context.getSharedPreferences("setting", 0)
    cityName = setting.getString("cityName", "").toString()
    apiKey = setting.getString("apiKey", "").toString()
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetSettingsData(this@MainActivity)
            WeatherTheme() {
                val daysList = remember {
                    mutableStateOf(listOf<WeatherModel>())
                }
                val dialogState = remember {
                    mutableStateOf(false)
                }

                val currentDay = remember {
                    mutableStateOf(
                        WeatherModel(
                            "",
                            "",
                            "",
                            "",
                            "0.0",
                            "",
                            "",
                            "0.0",
                            "0.0",
                            ""
                        )
                    )
                }
                if (dialogState.value) {
                    DialogSearch(dialogState, onSubmit = {
                        getData(it, this, daysList, currentDay)
                    })
                }
                getData(cityName, this, daysList, currentDay)
                Image(
                    painter = painterResource(
                        id = R.drawable.weather_bg
                    ),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard(currentDay, onClickSync = {
                        getData(cityName, this@MainActivity, daysList, currentDay)
                    }, onClickSearch = {
                        dialogState.value = true
                    }
                    )
                    Log.i("MyLog", "cityName = $cityName")
                    TabLayout(daysList, currentDay) {
                        GetSettingsData(this@MainActivity)
                        getData(cityName, this@MainActivity, daysList, currentDay)
                        Log.i("MyLog", "cityName = $cityName")
                        Log.i("MyLog", "apiKey = $apiKey")

                    }
                }
            }
        }
    }
}

fun getData(
    city: String, context: Context,
    daysList: MutableState<List<WeatherModel>>,
    currentDay: MutableState<WeatherModel>
) {

    val url = "https://api.weatherapi.com/v1/forecast.json?key=$apiKey" +
            "&q=$city" +
            "&days=" +
            "3" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val list = getWeatherByDays(response)
            currentDay.value = list[0]
            daysList.value = list
        },
        {
            Log.d("MyLog", "VolleyError: $it")
        }
    )
    queue.add(sRequest)
}

private fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) return listOf()
    val list = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location").getString("name")
    val region = mainObject.getJSONObject("location").getString("region")
    val country = mainObject.getJSONObject("location").getString("country")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")

    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                region,
                country,
                item.getString("date"),
                "",
                item.getJSONObject("day").getJSONObject("condition")
                    .getString("text"),
                item.getJSONObject("day").getJSONObject("condition")
                    .getString("icon"),
                item.getJSONObject("day").getString("maxtemp_c").toString(),
                item.getJSONObject("day").getString("mintemp_c").toString(),
                item.getJSONArray("hour").toString()

            )
        )
    }
    list[0] = list[0].copy(
        time = mainObject.getJSONObject("current").getString("last_updated"),
        currentTemp = showTemp(mainObject.getJSONObject("current")
            .getString("temp_c").toString()),
    )
    return list
}
