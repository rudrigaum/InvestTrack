package com.rodrigo.investtrack.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDto(
    @SerialName("stocks") val stocks: List<StockSearchDto> = emptyList(),
)

@Serializable
data class StockSearchDto(
    @SerialName("stock") val ticker: String,
    @SerialName("name") val name: String? = null,
    @SerialName("close") val close: Double? = null,
    @SerialName("change") val change: Double? = null,
    @SerialName("volume") val volume: Long? = null,
    @SerialName("market_cap") val marketCap: Long? = null,
    @SerialName("logo") val logoUrl: String? = null,
    @SerialName("sector") val sector: String? = null,
    @SerialName("type") val type: String? = null,
)
