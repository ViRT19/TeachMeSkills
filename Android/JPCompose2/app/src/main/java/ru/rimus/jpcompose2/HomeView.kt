package ru.rimus.jpcompose2

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun HomeView(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = Cyan30)
            .padding(15.dp)
    ) {
        Text(
            text = "Home Screen",
            fontSize = 46.sp,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 20.dp)
        )

        Image(
            modifier = Modifier
                .padding(top = 10.dp)
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.jpcompose),
            contentDescription = "JPCompose"
        )

        Button(
            onClick = { navController.navigate(route = Screen.SecondScreen.route) },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Change to Second Screen",
                fontSize = 20.sp
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize()
        ) {
            items(100) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ListCheckBox()
                    Text(text = "Item ${it + 1}", fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {navController.navigate(route = Screen.SecondScreen.route)}
                    )
                }
            }
        }
    }
}