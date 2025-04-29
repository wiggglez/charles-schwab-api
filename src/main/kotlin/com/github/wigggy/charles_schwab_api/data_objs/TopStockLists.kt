package com.github.wigggy.charles_schwab_api.data_objs

data class TopStockLists(
    val nasdaq: List<String>,
    val nasdaq100: List<String>,
    val sp500: List<String>,
    val sp100: List<String>,
    val etfTop25: List<String>
)
