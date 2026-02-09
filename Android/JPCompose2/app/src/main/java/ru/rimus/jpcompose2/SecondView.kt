package ru.rimus.jpcompose2

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.rimus.jpcompose2.ui.theme.Pink80

@Composable
fun SecondView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Pink80)
            .padding(15.dp)) {

        Text(text="Second Screen",
            fontSize= 46.sp,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 20.dp))

        Image(
            modifier = Modifier
                .padding(top=20.dp)
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.jpcompose),
            contentDescription = "JPCompose"
        )

        Button(onClick = {navController.navigate(route = Screen.HomeScreen.route)},
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Change to Home Screen", fontSize= 20.sp)
        }
    }
}