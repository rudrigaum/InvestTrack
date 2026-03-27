package com.rodrigo.investtrack.feature.home.domain.usecase

import com.rodrigo.investtrack.core.network.model.NetworkResult
import com.rodrigo.investtrack.feature.home.domain.model.Quote
import com.rodrigo.investtrack.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFeaturedQuotesUseCase
    @Inject
    constructor(
        private val repository: HomeRepository,
    ) {
        private val featuredTickers =
            listOf(
                "BBAS3",
                "PETR4",
                "VALE3",
                "ITUB4",
                "MGLU3",
            )

        operator fun invoke(): Flow<NetworkResult<List<Quote>>> =
            flow {
                emit(NetworkResult.Loading)

                val results =
                    featuredTickers.map { ticker ->
                        repository
                            .getFeaturedQuotes(ticker)
                            .filterIsInstance<NetworkResult.Success<List<Quote>>>()
                            .map { it.data }
                            .firstOrNull() ?: emptyList()
                    }

                val allQuotes = results.flatten()
                if (allQuotes.isNotEmpty()) {
                    emit(NetworkResult.Success(allQuotes))
                } else {
                    emit(NetworkResult.Error(message = "Unable to load quotes."))
                }
            }
    }
