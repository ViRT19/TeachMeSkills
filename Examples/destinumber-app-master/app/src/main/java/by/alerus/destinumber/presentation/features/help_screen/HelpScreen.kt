package by.alerus.destinumber.presentation.features.help_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.alerus.destinumber.R
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun HelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MarkdownText(
            markdown = stringResource(R.string.help_content),
            fontSize = 18.sp,
            lineHeight = 28.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.fillMaxSize()
        )
    }
} 