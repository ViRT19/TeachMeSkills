package ru.rimus.weather
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import ru.rimus.weather.databinding.ActivityMainBinding

const val API_KEY = "297ffc1c3e944aefaaf93152221705"
const val YANDEX_KEY = "e27948fd-03a3-4a29-b7be-49a83b6b17ec"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("London")
        }
    }
    private fun getResult(name: String){
        val url = "https://api.weather.yandex.ru/v2/forecast?lat=52.37125&lon=4.89388' -H 'X-Yandex-Weather-Key:$YANDEX_KEY"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                    response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog","Response: ${temp.getString("temp_c")}")
            },
            {
                Log.d("MyLog","Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }
}