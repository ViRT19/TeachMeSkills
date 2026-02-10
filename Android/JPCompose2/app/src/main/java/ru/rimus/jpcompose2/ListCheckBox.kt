package ru.rimus.jpcompose2

import android.util.Log
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer


@Composable
fun ListCheckBox(state: MutableState<Boolean>) {
    var isChecked by remember { mutableStateOf(state) }
    Checkbox(
        checked = isChecked,
        onCheckedChange = { it ->
            isChecked = it
            Log.d("MyLog", it.toString())
        },
        modifier = Modifier.graphicsLayer(scaleX = 2f, scaleY = 2f)
    )
}
