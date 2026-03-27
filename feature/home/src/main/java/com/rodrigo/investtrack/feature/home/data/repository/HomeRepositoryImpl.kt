package com.rodrigo.investtrack.feature.home.data.repository

import com.rodrigo.investtrack.core.network.model.NetworkResult
import com.rodrigo.investtrack.feature.home.data.datasource.HomeRemoteDataSource
import com.rodrigo.investtrack.feature.home.data.mapper.toDomain
import com.rodrigo.investtrack.feature.home.domain.model.Quote
import com.rodrigo.investtrack.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl
    @Inject
    constructor(
        private val remoteDataSource: HomeRemoteDataSource,
    ) : HomeRepository {
        override fun getFeaturedQuotes(tickers: String): Flow<NetworkResult<List<Quote>>> =
            flow {
                emit(NetworkResult.Loading)
                when (val result = remoteDataSource.getQuotes(tickers)) {
                    is NetworkResult.Success -> {
                        val quotes = result.data.results.map { it.toDomain() }
                        emit(NetworkResult.Success(quotes))
                    }
                    is NetworkResult.Error -> emit(result)
                    is NetworkResult.Loading -> Unit
                }
            }
    }
