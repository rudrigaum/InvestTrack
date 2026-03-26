// feature/home/src/main/java/com/rodrigo/investtrack/feature/home/data/datasource/HomeRemoteDataSource.kt

package com.rodrigo.investtrack.feature.home.data.datasource

import com.rodrigo.investtrack.core.network.api.BrApiService
import com.rodrigo.investtrack.core.network.dto.QuoteResponseDto
import com.rodrigo.investtrack.core.network.model.NetworkResult
import javax.inject.Inject

class HomeRemoteDataSource
    @Inject
    constructor(
        private val apiService: BrApiService,
    ) {
        suspend fun getQuotes(tickers: String): NetworkResult<QuoteResponseDto> =
            try {
                val response =
                    apiService.getQuotes(
                        tickers = tickers,
                        range = "1d",
                        interval = "1d",
                        fundamental = true,
                    )
                NetworkResult.Success(response)
            } catch (e: Exception) {
                NetworkResult.Error(
                    message = e.message,
                    throwable = e,
                )
            }
    }
