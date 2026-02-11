package ru.rimus.jpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.End
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(content = { padding: PaddingValues ->
                Column(modifier = Modifier.padding(padding)) {
                    CardJPC()
                }
            })
        }
    }
}

@Composable
fun CardJPC() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .border(width = 2.dp, color = Color.LightGray)
            .shadow(elevation = 5.dp, shape = RectangleShape)
            .fillMaxWidth()
    ) {
        Text(
            text = "Профиль пользователя",
            fontFamily = FontFamily(Font(R.font.deutschgothic)),
            fontSize = 24.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 25.dp)
                .fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Дубанов\nРодион",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = "Преподаватель",
                    fontFamily = FontFamily(Font(R.font.bookosbi)),
                    fontSize = 16.sp,
                    fontStyle= FontStyle.Italic,
                    color = Color.Gray,
                    modifier = Modifier.padding(end = 15.dp)
                )
            }
//            Spacer(modifier = Modifier.weight(1f),)
            Image(
                painterResource(id = R.drawable.rodion),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(100.dp)
            )
        }
        Buttons()
    }
}

@Composable
fun Buttons() {
    Row(modifier = Modifier.padding(all = 7.dp)) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 3.dp)
        ) { Text(text = "Позвонить") }
        Button(
            onClick = {},
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 3.dp)
        ) { Text(text = "Написать") }
        Button(
            onClick = {},
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 3.dp)
        ) { Text(text = "Добавить") }
    }
}