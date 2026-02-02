package ru.rimus.jpcompose

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(content = { padding: PaddingValues ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .background(Color.LightGray),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CardJPC(PaddingValues())
//                    Buttons()
                }
            })
        }

    }
}

@Composable
fun CardJPC(padding: PaddingValues) {
    Column() {
        Text(
            text = "Профиль пользователя",
            modifier = Modifier.padding(padding),
            fontSize = 24.sp
        )
        Row {
            Text(text = "ФИО", modifier = Modifier.weight(1f))
            //Image(image = R.drawable.rodion, contentDescription = "")
        }
    }
}

/*@Composable
fun Buttons() {
    Row {
        Button(onClick = {}) { text = "Позвонить") }
        Button(onClick = {}) { text = "Написать") }
        Button(onClick = {}) { text = "Добавить") }
    }
}*/
