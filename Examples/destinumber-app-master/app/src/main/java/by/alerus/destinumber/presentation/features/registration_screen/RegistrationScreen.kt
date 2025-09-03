package by.alerus.destinumber.presentation.features.registration_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.alerus.destinumber.R
import by.alerus.destinumber.presentation.theme.DestinumberTheme
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    onRegisterSuccess: () -> Unit,
    onBackToLogin: () -> Unit,
    viewModel: RegistrationViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState
    var showDatePicker by remember { mutableStateOf(false) }

    // Get localized strings
    val errorMessageGeneric = stringResource(R.string.registration_failed_generic)
    val errorMessageWithReason = stringResource(R.string.registration_failed_with_reason)

    LaunchedEffect(uiState.successMessage) {
        if (uiState.successMessage != null) {
            onRegisterSuccess()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button and title row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackToLogin,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Text(
                text = stringResource(R.string.registration_title),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        // Error message display
        if (uiState.error != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = uiState.error!!,
                        color = MaterialTheme.colorScheme.onErrorContainer,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    IconButton(
                        onClick = { viewModel.clearError() }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Clear error",
                            tint = MaterialTheme.colorScheme.onErrorContainer
                        )
                    }
                }
            }
        }

        // Username field
        OutlinedTextField(
            value = uiState.username,
            onValueChange = { viewModel.onUsernameChange(it) },
            label = { Text(stringResource(R.string.registration_username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            isError = !uiState.isUsernameValid,
            supportingText = {
                if (!uiState.isUsernameValid) {
                    Text(
                        text = stringResource(R.string.registration_username_pattern_error),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email field
        OutlinedTextField(
            value = uiState.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text(stringResource(R.string.registration_email)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            isError = !uiState.isEmailValid,
            supportingText = {
                if (!uiState.isEmailValid) {
                    Text(
                        text = stringResource(R.string.registration_email_invalid),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        OutlinedTextField(
            value = uiState.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text(stringResource(R.string.registration_password)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            visualTransformation = PasswordVisualTransformation(),
            isError = !uiState.isPasswordValid,
            supportingText = {
                if (!uiState.isPasswordValid) {
                    Text(
                        text = stringResource(R.string.registration_password_required),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Confirm Password field
        OutlinedTextField(
            value = uiState.confirmPassword,
            onValueChange = { viewModel.onConfirmPasswordChange(it) },
            label = { Text(stringResource(R.string.registration_confirm_password)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            visualTransformation = PasswordVisualTransformation(),
            isError = !uiState.isConfirmPasswordValid,
            supportingText = {
                if (!uiState.isConfirmPasswordValid) {
                    Text(
                        text = stringResource(R.string.registration_passwords_not_match),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // First Name field
        OutlinedTextField(
            value = uiState.firstName,
            onValueChange = { viewModel.onFirstNameChange(it) },
            label = { Text(stringResource(R.string.registration_first_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Last Name field
        OutlinedTextField(
            value = uiState.lastName,
            onValueChange = { viewModel.onLastNameChange(it) },
            label = { Text(stringResource(R.string.registration_last_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Date of Birth field
        OutlinedTextField(
            value = uiState.dateOfBirth?.format(DateTimeFormatter.ISO_LOCAL_DATE) ?: "",
            onValueChange = { },
            label = { Text(stringResource(R.string.registration_date_of_birth)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = true }) {
                    Icon(Icons.Default.Person, contentDescription = "Select date")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Register button
        Button(
            onClick = { 
                viewModel.register(
                    onSuccess = onRegisterSuccess,
                    errorMessageGeneric = errorMessageGeneric,
                    errorMessageWithReason = errorMessageWithReason
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            enabled = !uiState.isLoading && 
                     uiState.username.isNotBlank() && 
                     uiState.password.isNotBlank() &&
                     uiState.confirmPassword.isNotBlank()
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text(stringResource(R.string.registration_register))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Back to login link
        TextButton(
            onClick = onBackToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(stringResource(R.string.registration_already_have_account))
        }
    }

    // Date picker dialog
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = uiState.dateOfBirth?.atStartOfDay(ZoneId.systemDefault())?.toInstant()?.toEpochMilli(),
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    // Allow dates from 1900 to today
                    val calendar = Calendar.getInstance()
                    val minCalendar = Calendar.getInstance().apply {
                        set(1900, 0, 1, 0, 0, 0)
                        set(Calendar.MILLISECOND, 0)
                    }
                    return utcTimeMillis >= minCalendar.timeInMillis && utcTimeMillis <= calendar.timeInMillis
                }

                override fun isSelectableYear(year: Int): Boolean {
                    return year in 1900..Calendar.getInstance().get(Calendar.YEAR)
                }
            }
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
                            viewModel.onDateOfBirthChange(selectedDate)
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDatePicker = false }
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

@Preview
@Composable
fun RegistrationScreenPreview() {
    DestinumberTheme(darkTheme = true) {
        RegistrationScreen(
            onRegisterSuccess = {},
            onBackToLogin = {}
        )
    }
} 