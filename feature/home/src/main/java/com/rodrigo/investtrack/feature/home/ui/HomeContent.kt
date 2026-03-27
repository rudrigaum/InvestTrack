package com.rodrigo.investtrack.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rodrigo.investtrack.core.ui.component.ErrorMessage
import com.rodrigo.investtrack.core.ui.component.LoadingIndicator
import com.rodrigo.investtrack.core.ui.theme.InvestTrackTheme
import com.rodrigo.investtrack.core.ui.theme.PriceNegative
import com.rodrigo.investtrack.core.ui.theme.PricePositive
import com.rodrigo.investtrack.feature.home.domain.model.Quote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    uiState: HomeUiState,
    onQuoteClick: (String) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "InvestTrack",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
            )
        },
    ) { paddingValues ->
        when {
            uiState.isLoading -> {
                LoadingIndicator(modifier = Modifier.padding(paddingValues))
            }
            uiState.errorMessage != null -> {
                ErrorMessage(
                    message = uiState.errorMessage,
                    onRetry = onRetry,
                    modifier = Modifier.padding(paddingValues),
                )
            }
            uiState.hasContent -> {
                QuoteList(
                    quotes = uiState.quotes,
                    onQuoteClick = onQuoteClick,
                    contentPadding = paddingValues,
                )
            }
        }
    }
}

@Composable
private fun QuoteList(
    quotes: List<Quote>,
    onQuoteClick: (String) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = quotes,
            key = { it.ticker },
        ) { quote ->
            QuoteCard(
                quote = quote,
                onClick = { onQuoteClick(quote.ticker) },
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
    }
}

@Composable
private fun QuoteCard(
    quote: Quote,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = quote.logoUrl,
                contentDescription = "${quote.shortName} logo",
                modifier = Modifier.size(40.dp),
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.ticker,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = quote.shortName,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "R$ ${"%.2f".format(quote.currentPrice)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = quote.formattedChangePercent as String,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (quote.isPositive) PricePositive else PriceNegative,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    InvestTrackTheme {
        HomeContent(
            uiState =
                HomeUiState(
                    quotes =
                        listOf(
                            Quote(
                                ticker = "BBAS3",
                                shortName = "Banco do Brasil",
                                longName = "Banco do Brasil S.A.",
                                currentPrice = 56.78,
                                changePercent = 1.25,
                                change = 0.70,
                                openPrice = 56.08,
                                highPrice = 57.10,
                                lowPrice = 55.90,
                                previousClose = 56.08,
                                volume = 12345678L,
                                marketCap = 98765432100L,
                                logoUrl = null,
                                currency = "BRL",
                            ),
                        ),
                ),
            onQuoteClick = {},
            onRetry = {},
        )
    }
}
