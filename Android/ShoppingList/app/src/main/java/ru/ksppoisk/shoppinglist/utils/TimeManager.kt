package ru.ksppoisk.shoppinglist.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object TimeManager {
    fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("dd.MM.YYYY - hh:mm:ss", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }
}