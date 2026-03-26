package com.rodrigo.investtrack.feature.home.domain.model

data class Quote(
    val ticker: String,
    val shortName: String,
    val longName: String,
    val currentPrice: Double,
    val changePercent: Double,
    val change: Double,
    val openPrice: Double,
    val highPrice: Double,
    val lowPrice: Double,
    val previousClose: Double,
    val volume: Long,
    val marketCap: Long?,
    val logoUrl: String?,
    val currency: String,
) {
    val isPositive: Boolean get() = changePercent >= 0

    val formattedChangePercent: String
        get() {
            val sign = if (isPositive) "+" else ""
            return "$sign${"%.2f".format(changePercent)}%"
        }
}
