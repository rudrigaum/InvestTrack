package com.rodrigo.investtrack.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeResponseDto(
    @SerialName("currency") val currency: List<CurrencyDto> = emptyList(),
)

@Serializable
data class CurrencyDto(
    @SerialName("fromCurrency") val fromCurrency: String? = null,
    @SerialName("toCurrency") val toCurrency: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("high") val high: Double? = null,
    @SerialName("low") val low: Double? = null,
    @SerialName("bidVariation") val bidVariation: Double? = null,
    @SerialName("percentageChange") val percentageChange: String? = null,
    @SerialName("bidPrice") val bidPrice: Double? = null,
    @SerialName("askPrice") val askPrice: Double? = null,
    @SerialName("updatedAtTimestamp") val updatedAtTimestamp: String? = null,
    @SerialName("updatedAtDate") val updatedAtDate: String? = null,
)
