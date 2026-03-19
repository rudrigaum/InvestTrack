package com.rodrigo.investtrack.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteResponseDto(
    @SerialName("results") val results: List<QuoteDto> = emptyList(),
    @SerialName("requestedAt") val requestedAt: String? = null,
    @SerialName("took") val took: String? = null,
)

@Serializable
data class QuoteDto(
    @SerialName("symbol") val symbol: String,
    @SerialName("shortName") val shortName: String? = null,
    @SerialName("longName") val longName: String? = null,
    @SerialName("currency") val currency: String? = null,
    @SerialName("regularMarketPrice") val regularMarketPrice: Double? = null,
    @SerialName("regularMarketChangePercent") val regularMarketChangePercent: Double? = null,
    @SerialName("regularMarketChange") val regularMarketChange: Double? = null,
    @SerialName("regularMarketOpen") val regularMarketOpen: Double? = null,
    @SerialName("regularMarketDayHigh") val regularMarketDayHigh: Double? = null,
    @SerialName("regularMarketDayLow") val regularMarketDayLow: Double? = null,
    @SerialName("regularMarketVolume") val regularMarketVolume: Long? = null,
    @SerialName("regularMarketPreviousClose") val regularMarketPreviousClose: Double? = null,
    @SerialName("fiftyTwoWeekHigh") val fiftyTwoWeekHigh: Double? = null,
    @SerialName("fiftyTwoWeekLow") val fiftyTwoWeekLow: Double? = null,
    @SerialName("marketCap") val marketCap: Long? = null,
    @SerialName("logourl") val logoUrl: String? = null,
    @SerialName("historicalDataPrice") val historicalDataPrice: List<HistoricalPriceDto> = emptyList(),
    @SerialName("dividendsData") val dividendsData: DividendsDataDto? = null,
    @SerialName("priceEarnings") val priceEarnings: Double? = null,
    @SerialName("earningsPerShare") val earningsPerShare: Double? = null,
)

@Serializable
data class HistoricalPriceDto(
    @SerialName("date") val date: Long? = null,
    @SerialName("open") val open: Double? = null,
    @SerialName("high") val high: Double? = null,
    @SerialName("low") val low: Double? = null,
    @SerialName("close") val close: Double? = null,
    @SerialName("volume") val volume: Long? = null,
    @SerialName("adjustedClose") val adjustedClose: Double? = null,
)

@Serializable
data class DividendsDataDto(
    @SerialName("cashDividends") val cashDividends: List<CashDividendDto> = emptyList(),
)

@Serializable
data class CashDividendDto(
    @SerialName("assetIssued") val assetIssued: String? = null,
    @SerialName("paymentDate") val paymentDate: String? = null,
    @SerialName("rate") val rate: Double? = null,
    @SerialName("relatedTo") val relatedTo: String? = null,
    @SerialName("approvedOn") val approvedOn: String? = null,
    @SerialName("isinCode") val isinCode: String? = null,
    @SerialName("label") val label: String? = null,
    @SerialName("lastDatePrior") val lastDatePrior: String? = null,
    @SerialName("remarks") val remarks: String? = null,
)
