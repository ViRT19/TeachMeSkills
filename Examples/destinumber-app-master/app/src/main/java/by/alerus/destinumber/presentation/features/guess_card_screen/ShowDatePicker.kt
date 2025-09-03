package by.alerus.destinumber.presentation.features.guess_card_screen

import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDatePicker(
    selectedDate: Date? = null,
    onDateSelected: (Date) -> Unit
) {
    var showPicker by remember { mutableStateOf(false) }
    var currentDate by remember {
        mutableStateOf(
            selectedDate ?: Date()
        )
    }
    var displayText by remember {
        mutableStateOf(formatDate(currentDate))
    }

    Text(
        displayText,
        modifier = Modifier.clickable { showPicker = true }
    )

    if (showPicker) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = currentDate.time,
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    // Get start of today (midnight)
                    val calendar = Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                        set(Calendar.MILLISECOND, 0)
                    }
                    // Allow dates from today (midnight) onward
                    return utcTimeMillis >= calendar.timeInMillis
                }

                override fun isSelectableYear(year: Int): Boolean {
                    return year >= Calendar.getInstance().get(Calendar.YEAR)
                }
            }
        )

        DatePickerDialog(
            onDismissRequest = { showPicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val newDate = Date(millis)
                            currentDate = newDate
                            displayText = formatDate(newDate)
                            onDateSelected(newDate)
                        }
                        showPicker = false
                    }
                ) { Text("OK") }
            },
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

private fun formatDate(date: Date): String {
    return SimpleDateFormat
        .getDateInstance(SimpleDateFormat.MEDIUM, Locale.getDefault())
        .format(date)
}