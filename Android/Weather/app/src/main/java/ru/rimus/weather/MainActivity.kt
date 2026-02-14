import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.rimus.weather.fetchYandexWeatherJson

class MainActivity : ComponentActivity() {

    private val API_KEY = "123e4567-e89b-12d3-a456-4000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                WeatherJsonScreen(apiKey = API_KEY)
            }
        }
    }
}

@Composable
fun WeatherJsonScreen(apiKey: String) {
    val context = LocalContext.current
    var jsonText by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val json = fetchYandexWeatherJson(
                context = context,
                lat = 59.9343,
                lon = 30.3351,
                apiKey = apiKey
            )
            jsonText = json.toString(2)
            error = null
        } catch (e: Exception) {
            error = e.message
            jsonText = ""
        } finally {
            isLoading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                scope.launch {
                    isLoading = true
                    try {
                        val json = fetchYandexWeatherJson(
                            context = context,
                            lat = 59.9343,
                            lon = 30.3351,
                            apiKey = apiKey
                        )
                        jsonText = json.toString(2)
                        error = null
                    } catch (e: Exception) {
                        error = e.message
                        jsonText = ""
                    } finally {
                        isLoading = false
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Обновить")
        }

        when {
            isLoading -> Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            error != null -> Text("Ошибка: $error", modifier = Modifier.padding(16.dp))
            else -> LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    Text(
                        text = jsonText,
                        fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                        fontSize = MaterialTheme.typography.body2.fontSize
                    )
                }
            }
        }
    }
}
