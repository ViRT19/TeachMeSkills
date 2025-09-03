package by.alerus.destinumber.presentation.features.guess_card_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import by.alerus.destinumber.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.alerus.destinumber.presentation.theme.DestinumberTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun GuessCardScreen(
    viewModel: GuessViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            ShowDatePicker(
                selectedDate = state.selectedDate,
                onDateSelected = { newDate ->
                    viewModel.onDateSelected(newDate)
                }
            )
        }

        Box(
            modifier = Modifier.wrapContentHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DestinyCardGrid(
                modifier = Modifier,
                onCardSelected = { cardNumber ->
                    viewModel.onCardSelected(cardNumber)
                }
            )
        }

        Box(
            modifier = Modifier.weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            when (val uiState = state.uiState) {
                is GuessUiState.Loading -> CircularProgressIndicator()
                is GuessUiState.Success -> Text(uiState.prediction, textAlign = TextAlign.Center)
                is GuessUiState.Nothing -> Text(stringResource(R.string.draw_card), textAlign = TextAlign.Center)
                is GuessUiState.Error -> Text(
                    when {
                        uiState.message == "Unknown error" -> stringResource(R.string.error_unknown)
                        uiState.message.lowercase().contains("server") -> stringResource(R.string.error_server)
                        uiState.message.lowercase().contains("client") -> stringResource(R.string.error_client)
                        else -> ""
                    }, textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview
@Composable
fun GuessCardScreenPreview() {
    DestinumberTheme (
        darkTheme = true
    ) {
        GuessCardScreen()
    }
}