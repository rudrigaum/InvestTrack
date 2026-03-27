package com.rodrigo.investtrack.feature.home.domain.repository

import com.rodrigo.investtrack.core.network.model.NetworkResult
import com.rodrigo.investtrack.feature.home.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getFeaturedQuotes(tickers: String): Flow<NetworkResult<List<Quote>>>
}
