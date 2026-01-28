package ru.rimus.weather
// top 10 free api: https://habr.com/ru/articles/881814/

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import ru.rimus.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val KEY="e27948fd-03a3-4a29-b7be-49a83b6b17ec"
    val API_KEY="297ffc1c3e944aefaaf93152221705"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("Sarov")
        }
    }

    private fun getResult(name: String) {
        val url = 'https://api.weather.yandex.ru/v2/forecast?lat=52.37125&lon=4.89388' -H 'X-Yandex-Weather-Key: e27948fd-03a3-4a29-b7be-49a83b6b17ec'



        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, url,
            {response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog", "Response: ${temp.getString("temp_c")}")},
            { Log.d("MyLog", "Volley error: ${it.toString()}") })
        queue.add(stringRequest)
    }
}