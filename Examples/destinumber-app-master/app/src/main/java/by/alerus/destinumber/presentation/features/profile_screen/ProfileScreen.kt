package by.alerus.destinumber.presentation.features.profile_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import by.alerus.destinumber.R
import androidx.compose.ui.tooling.preview.Preview
import by.alerus.destinumber.presentation.theme.DestinumberTheme
import org.koin.androidx.compose.koinViewModel
import java.time.format.DateTimeFormatter
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState
    
    // Get localized strings
    val loadFailMessage = stringResource(R.string.profile_load_fail)
    val updateSuccessMessage = stringResource(R.string.profile_update_success)
    val updateFailMessage = stringResource(R.string.profile_update_fail)
    
    LaunchedEffect(Unit) {
        viewModel.loadProfile(loadFailMessage)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Text(
            text = stringResource(R.string.profile_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            uiState.profile != null -> {
                ProfileContent(
                    uiState = uiState,
                    onStartEditing = { viewModel.startEditing() },
                    onCancelEditing = { viewModel.cancelEditing() },
                    onSave = { 
                        viewModel.saveProfile(updateSuccessMessage, updateFailMessage)
                    },
                    onFieldChange = { field, value -> viewModel.updateField(field, value) },
                    onDateChange = { date -> viewModel.updateDateOfBirth(date) }
                )
            }
            else -> {
                Text(
                    text = "No profile data available",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Error message
        uiState.error?.let { error ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.onErrorContainer,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // Success message
        uiState.successMessage?.let { message ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun ProfileContent(
    uiState: ProfileUiState,
    onStartEditing: () -> Unit,
    onCancelEditing: () -> Unit,
    onSave: () -> Unit,
    onFieldChange: (String, String) -> Unit,
    onDateChange: (LocalDate?) -> Unit
) {
    val profile = uiState.profile ?: return
    val editedProfile = uiState.editedProfile ?: return
    val isEditing = uiState.isEditing

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Destiny Number Card (Read-only)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.profile_destiny_number),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = profile.destinyNumber.toString(),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        // Prediction Attempts Card (Read-only)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.profile_prediction_attempts),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = profile.predictionAttempts.toString(),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }

        // Username
        ProfileField(
            label = stringResource(R.string.profile_username),
            value = if (isEditing) editedProfile.username else profile.username,
            onValueChange = { onFieldChange("username", it) },
            enabled = isEditing,
            isRequired = true
        )

        // Email
        ProfileField(
            label = stringResource(R.string.profile_email),
            value = if (isEditing) editedProfile.email ?: "" else profile.email ?: "",
            onValueChange = { onFieldChange("email", it) },
            enabled = isEditing
        )

        // First Name
        ProfileField(
            label = stringResource(R.string.profile_first_name),
            value = if (isEditing) editedProfile.firstName ?: "" else profile.firstName ?: "",
            onValueChange = { onFieldChange("firstName", it) },
            enabled = isEditing
        )

        // Last Name
        ProfileField(
            label = stringResource(R.string.profile_last_name),
            value = if (isEditing) editedProfile.lastName ?: "" else profile.lastName ?: "",
            onValueChange = { onFieldChange("lastName", it) },
            enabled = isEditing
        )

        // Date of Birth
        DateOfBirthField(
            label = stringResource(R.string.profile_date_of_birth),
            date = if (isEditing) editedProfile.dateOfBirth else profile.dateOfBirth,
            onDateChange = onDateChange,
            enabled = isEditing
        )

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (isEditing) {
                Button(
                    onClick = onSave,
                    modifier = Modifier.weight(1f),
                    enabled = !uiState.isLoading
                ) {
                    Icon(Icons.Default.Save, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(stringResource(R.string.profile_save))
                }

                OutlinedButton(
                    onClick = onCancelEditing,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Cancel, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(stringResource(R.string.profile_cancel))
                }
            } else {
                Button(
                    onClick = onStartEditing,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Edit, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(stringResource(R.string.profile_edit))
                }
            }
        }
    }
}

@Composable
private fun ProfileField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean,
    isRequired: Boolean = false,
    placeholder: String? = null
) {
    Column {
        Text(
            text = if (isRequired) "$label *" else label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (enabled) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                placeholder = placeholder?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
        } else {
            Text(
                text = value.ifBlank { "—" },
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DateOfBirthField(
    label: String,
    date: LocalDate?,
    onDateChange: (LocalDate?) -> Unit,
    enabled: Boolean
) {
    var showDatePicker by remember { mutableStateOf(false) }
    
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(4.dp))
        
        if (enabled) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = date?.format(DateTimeFormatter.ISO_LOCAL_DATE) ?: "",
                    onValueChange = { },
                    enabled = false,
                    placeholder = { Text("YYYY-MM-DD") },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(
                            onClick = { showDatePicker = true }
                        ) {
                            Icon(
                                Icons.Default.CalendarToday,
                                contentDescription = "Select date"
                            )
                        }
                    }
                )
                
                if (date != null) {
                    OutlinedButton(
                        onClick = { onDateChange(null) }
                    ) {
                        Text(stringResource(R.string.profile_clear))
                    }
                }
            }
        } else {
            Text(
                text = date?.format(DateTimeFormatter.ISO_LOCAL_DATE) ?: "—",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
    
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = date?.atStartOfDay(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
        )
        
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDateMillis = datePickerState.selectedDateMillis
                        if (selectedDateMillis != null) {
                            val selectedDate = java.time.Instant.ofEpochMilli(selectedDateMillis)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                            onDateChange(selectedDate)
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                showModeToggle = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    DestinumberTheme(darkTheme = true) {
        ProfileScreen()
    }
} 