package ru.rimus.jpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rimus.jpcompose.ui.theme.JPComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JPComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier
            .wrapContentSize()
            .border(5.dp, color = Color.Red)
            .padding(20.dp)
    ) {
        Image(painterResource(R.drawable.ic_basket), "")
        Column(Modifier.padding(start = 10.dp))
        {
            Text(text = "Карточка товара")
            Text(text = "Цена: ")
            Button(onClick = {

            }) { Text(text = "Купить") }

        }
    }
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MainUi(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://i.pravatar.cc/",
            contentDescription = "Avatar",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Text(
            "Random User",
            modifier = Modifier.padding(top = 22.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Phone number: + 123 456 789",
            modifier = Modifier
                .padding(top = 22.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "City: Moscow",
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.bodyMedium
        )
        Row(
            modifier = Modifier
                .padding(top = 22.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            IconButton(onClick = {}, Modifier.size(72.dp)) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Call",
                    tint = Color.Green,
                    modifier = Modifier.fillMaxSize()
                )
            }
            IconButton(onClick = {}, Modifier.size(72.dp)) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Message",
                    tint = Color.Blue,
                    modifier = Modifier.fillMaxSize()
                )
            }
            IconButton(onClick = {}, Modifier.size(72.dp)) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Black,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainUiPreview() {
    Homework38Theme {
        MainUi()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JPComposeTheme {
        Greeting("Android")
    }
}