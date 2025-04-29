package com.github.wigggy.charles_schwab_api.data_objs.stockchart

import java.util.*

data class CharlesSchwabHistoricData(
    val ticker: String,
    val candleSize: String,
    val periodSize: String,
    val prepost: Boolean,
    val datetime: List<Date>,
    val timestamp: List<Long>,
    val open: List<Double>,
    val high: List<Double>,
    val low: List<Double>,
    val close: List<Double>,
    val volume: List<Int>,
)


