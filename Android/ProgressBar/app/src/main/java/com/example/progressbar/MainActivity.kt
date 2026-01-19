import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loader = findViewById<CircleLoader>(R.id.circleLoader)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)

        btnStart.setOnClickListener {
            loader.startLoading()

            // Симулируем загрузку
            Handler(Looper.getMainLooper()).postDelayed({
                loader.stopLoading()
                Toast.makeText(this, "Готово!", Toast.LENGTH_SHORT).show()
            }, 3000)
        }

        btnStop.setOnClickListener {
            loader.stopLoading()
        }

        // Автостарт
        loader.startLoading()
    }

    override fun onPause() {
        super.onPause()
        val loader = findViewById<CircleLoader>(R.id.circleLoader)
        loader.stopLoading()
    }
}