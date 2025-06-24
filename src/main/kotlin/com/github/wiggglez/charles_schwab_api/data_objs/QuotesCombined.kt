package com.github.wiggglez.charles_schwab_api.data_objs

data class QuotesCombined(
    val stockQuoteMap: Map<String, StockQuote>,
    val optionQuoteMap: Map<String, OptionQuote>
)
