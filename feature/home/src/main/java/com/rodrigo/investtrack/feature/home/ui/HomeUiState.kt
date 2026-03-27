package com.rodrigo.investtrack.feature.home.ui

import com.rodrigo.investtrack.feature.home.domain.model.Quote

data class HomeUiState(
    val isLoading: Boolean = false,
    val quotes: List<Quote> = emptyList(),
    val errorMessage: String? = null,
) {
    val showEmptyState: Boolean
        get() = !isLoading && quotes.isEmpty() && errorMessage == null

    val hasContent: Boolean
        get() = quotes.isNotEmpty()
}
