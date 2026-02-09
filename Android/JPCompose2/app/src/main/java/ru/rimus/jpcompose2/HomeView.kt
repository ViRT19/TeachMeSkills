package ru.rimus.jpcompose2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.rimus.jpcompose2.ui.theme.Cyan30
import ru.rimus.jpcompose2.ui.theme.Purple40

@Composable
fun HomeView(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = Cyan30)
            .padding(15.dp)
    ) {
        Text(text="Home Screen",
            fontSize= 46.sp,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 20.dp)
        )

        Image(
            modifier = Modifier
                .padding(top=20.dp)
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.jpcompose),
            contentDescription = "JPCompose"
        )

        Button(
            onClick = { navController.navigate(route = Screen.SecondScreen.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Change to Second Screen",
                fontSize = 20.sp)
        }
    }
}