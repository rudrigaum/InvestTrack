package com.rodrigo.investtrack.core.network.api

import com.rodrigo.investtrack.core.network.dto.ExchangeResponseDto
import com.rodrigo.investtrack.core.network.dto.QuoteResponseDto
import com.rodrigo.investtrack.core.network.dto.SearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BrApiService {
    @GET("quote/{tickers}")
    suspend fun getQuotes(
        @Path("tickers") tickers: String,
        @Query("range") range: String = "1d",
        @Query("interval") interval: String = "1d",
        @Query("fundamental") fundamental: Boolean = false,
        @Query("dividends") dividends: Boolean = false,
    ): QuoteResponseDto

    @GET("quote/list")
    suspend fun searchAssets(
        @Query("search") query: String,
    ): SearchResponseDto

    @GET("v2/currency")
    suspend fun getExchangeRates(
        @Query("currency") currency: String = "USD-BRL,EUR-BRL,BTC-BRL,GBP-BRL",
    ): ExchangeResponseDto
}
