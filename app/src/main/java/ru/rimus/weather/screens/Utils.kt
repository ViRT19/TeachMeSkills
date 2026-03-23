package ru.rimus.weather.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import ru.rimus.weather.R
import ru.rimus.weather.ui.theme.BlueLight
import ru.rimus.weather.ui.theme.Gray
import ru.rimus.weather.ui.theme.White
import kotlin.math.abs
import kotlin.math.roundToInt

object Utils {

    fun showTemp(t: String): String {
        var s = ""
        val tI = t.toFloat().roundToInt()
        if (tI < 0) s = "–"
        if (tI > 0) s = "+"
        return s + abs(tI).toString() + " °C"
    }

    @Composable
    fun SettingScreen(onSaveClick :() -> Unit) {
        val setting = LocalContext.current.getSharedPreferences("setting", 0)
        val loginString = setting.getString("cityName", "")
        val passString = setting.getString("apiKey", "")

        Card(
            backgroundColor = BlueLight,
            shape = RoundedCornerShape(5.dp),
            elevation = 0.dp,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(Modifier.height(20.dp))

                Text(
                    text = "Settings",
                    fontSize = 28.sp,
                    fontWeight = Bold,
                    color = White
                )

                var cityName by remember { mutableStateOf("$loginString") }
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    value = cityName,
                    onValueChange = { cityName = it },
                    shape = RoundedCornerShape(6.dp),
                    placeholder = {
                        Text(
                            text = "City",
                            fontSize = 20.sp,
                            color = Gray,
                        )
                    }, singleLine = true,
                    label = {
                        Text(
                            text = "City",
                            fontSize = 18.sp,
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                cityName = ""
                            },
                        ) {
                            Icon(
                                painterResource(R.drawable.design_ic_clear),
                                contentDescription = "Clear City"
                            )
                        }
                    }
                )

                var apiKey by remember { mutableStateOf("$passString") }
                var passwordVisability by remember { mutableStateOf(false) }
                val icon = if (passwordVisability)
                    painterResource(id = R.drawable.design_ic_visibility)
                else
                    painterResource(id = R.drawable.design_ic_visibility_off)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    value = apiKey,
                    onValueChange = { apiKey = it },
                    shape = RoundedCornerShape(6.dp),
                    placeholder = {
                        Text(
                            text = "Api Key",
                            fontSize = 20.sp,
                            color = Gray,
                        )
                    }, singleLine = true,
                    label = {
                        Text(
                            text = "Api Key",
                            fontSize = 18.sp,
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisability = !passwordVisability
                        }) {
                            Icon(
                                painter = icon,
                                contentDescription = "Visibility Icon"
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (passwordVisability) VisualTransformation.None
                    else PasswordVisualTransformation()
                )

                Button(
                    shape = RoundedCornerShape(6.dp),
                    onClick = {
                        setting.edit {
                            putString("cityName", cityName)
                            putString("apiKey", apiKey)
                        }
                        onSaveClick()
                    },

                    border = BorderStroke(2.dp, Color.White),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(60.dp)
                ) {
                    Text(
                        text = "Save",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .height(30.dp)
                            .padding(top = 5.dp)
                    )
                }
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}