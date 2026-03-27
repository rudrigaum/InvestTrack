package com.rodrigo.investtrack.feature.home.data.mapper

import com.rodrigo.investtrack.core.network.dto.QuoteDto
import com.rodrigo.investtrack.feature.home.domain.model.Quote

fun QuoteDto.toDomain(): Quote =
    Quote(
        ticker = symbol,
        shortName = shortName ?: symbol,
        longName = longName ?: shortName ?: symbol,
        currentPrice = regularMarketPrice ?: 0.0,
        changePercent = regularMarketChangePercent ?: 0.0,
        change = regularMarketChange ?: 0.0,
        openPrice = regularMarketOpen ?: 0.0,
        highPrice = regularMarketDayHigh ?: 0.0,
        lowPrice = regularMarketDayLow ?: 0.0,
        previousClose = regularMarketPreviousClose ?: 0.0,
        volume = regularMarketVolume ?: 0L,
        marketCap = marketCap,
        logoUrl = logoUrl,
        currency = currency ?: "BRL",
    )
