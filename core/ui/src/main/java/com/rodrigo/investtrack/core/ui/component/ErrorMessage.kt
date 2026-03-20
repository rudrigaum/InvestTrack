package com.rodrigo.investtrack.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigo.investtrack.core.ui.theme.InvestTrackTheme

@Composable
fun ErrorMessage(
    message: String,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            modifier = Modifier.size(48.dp),
            tint = MaterialTheme.colorScheme.error,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
        if (onRetry != null) {
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onRetry) {
                Text(text = "Try again")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorMessagePreview() {
    InvestTrackTheme {
        ErrorMessage(
            message = "Unable to load data. Please check your connection.",
            onRetry = {},
        )
    }
}

@Preview(showBackground = true, name = "Without retry")
@Composable
private fun ErrorMessageNoRetryPreview() {
    InvestTrackTheme {
        ErrorMessage(
            message = "Something went wrong.",
        )
    }
}
