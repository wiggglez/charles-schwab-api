package com.github.wigggy.charles_schwab_api.data_objs.responses

import com.github.wigggy.charles_schwab_api.data_objs.OptionQuote

internal data class OptionQuoteResp(
    val assetMainType: String?,
    val realtime: Boolean?,
    val ssid: Long?,
    val symbol: String?,
    val quote: OptionQuoteRespData,
    val reference: Ref
)

internal data class OptionQuoteRespData(
    val weekHigh52: Double?,
    val weekLow52: Double?,
    val askPrice: Double?,
    val askSize: Int?,
    val bidPrice: Double?,
    val bidSize: Int?,
    val closePrice: Double?,
    val delta: Double?,
    val gamma: Double?,
    val highPrice: Double?,
    val indAskPrice: Double?,
    val indBidPrice: Double?,
    val indQuoteTime: Long?,
    val impliedYield: Double?,
    val lastPrice: Double?,
    val lastSize: Int?,
    val lowPrice: Double?,
    val mark: Double?,
    val markChange: Double?,
    val markPercentChange: Double?,
    val moneyIntrinsicValue: Double?,
    val netChange: Double?,
    val netPercentChange: Double?,
    val openInterest: Int?,
    val openPrice: Double?,
    val quoteTime: Long?,
    val rho: Double?,
    val securityStatus: String?,
    val theoreticalOptionValue: Double?,
    val theta: Double?,
    val timeValue: Double?,
    val totalVolume: Int?,
    val tradeTime: Long?,
    val underlyingPrice: Double?,
    val vega: Double?,
    val volatility: Double?
)

internal data class Ref(
    val contractType: String?,
    val daysToExpiration: Int?,
    val deliverables: String?,
    val description: String?,
    val exchange: String?,
    val exchangeName: String?,
    val exerciseType: String?,
    val expirationDay: Int?,
    val expirationMonth: Int?,
    val expirationType: String?,
    val expirationYear: Int?,
    val isPennyPilot: Boolean?,
    val lastTradingDay: Long?,
    val multiplier: Double?,
    val settlementType: String?,
    val strikePrice: Double?,
    val underlying: String?
)


/** Converts OptionQuoteResp to OptionQuote.
 *
 * Main differences is that the Resp may contain null values AND
 * OptionQuote has all dollar values multiplied by 100. This
 * function provides default values so that all OptionQuote values are non-null.*/
internal fun OptionQuoteResp.toOptionQuote(): OptionQuote {
    return OptionQuote(
        assetMainType = this.assetMainType ?: "Unknown",
        realtime = this.realtime ?: false,
        ssid = this.ssid ?: 0L,
        symbol = this.symbol ?: "Unknown",

        weekHigh52 = this.quote.weekHigh52?.times(100.0) ?: 0.0,
        weekLow52 = this.quote.weekLow52?.times(100.0) ?: 0.0,
        askPrice = this.quote.askPrice?.times(100.0) ?: 0.0,
        askSize = this.quote.askSize ?: 0,
        bidPrice = this.quote.bidPrice?.times(100.0) ?: 0.0,
        bidSize = this.quote.bidSize ?: 0,
        closePrice = this.quote.closePrice?.times(100.0) ?: 0.0,
        delta = this.quote.delta ?: 0.0,
        gamma = this.quote.gamma ?: 0.0,
        highPrice = this.quote.highPrice?.times(100.0) ?: 0.0,
        indAskPrice = this.quote.indAskPrice?.times(100.0) ?: 0.0,
        indBidPrice = this.quote.indBidPrice?.times(100.0) ?: 0.0,
        indQuoteTime = this.quote.indQuoteTime ?: 0L,
        impliedYield = this.quote.impliedYield ?: 0.0,
        lastPrice = this.quote.lastPrice?.times(100.0) ?: 0.0,
        lastSize = this.quote.lastSize ?: 0,
        lowPrice = this.quote.lowPrice?.times(100.0) ?: 0.0,
        mark = this.quote.mark?.times(100.0) ?: 0.0,
        markChange = this.quote.markChange?.times(100.0) ?: 0.0,
        markPercentChange = this.quote.markPercentChange ?: 0.0,
        moneyIntrinsicValue = this.quote.moneyIntrinsicValue?.times(100.0) ?: 0.0,
        netChange = this.quote.netChange?.times(100.0) ?: 0.0,
        netPercentChange = this.quote.netPercentChange ?: 0.0,
        openInterest = this.quote.openInterest ?: 0,
        openPrice = this.quote.openPrice?.times(100.0) ?: 0.0,
        quoteTime = this.quote.quoteTime ?: 0L,
        rho = this.quote.rho ?: 0.0,
        securityStatus = this.quote.securityStatus ?: "Unknown",
        theoreticalOptionValue = this.quote.theoreticalOptionValue?.times(100.0) ?: 0.0,
        theta = this.quote.theta ?: 0.0,
        timeValue = this.quote.timeValue?.times(100.0) ?: 0.0,
        totalVolume = this.quote.totalVolume ?: 0,
        tradeTime = this.quote.tradeTime ?: 0L,
        underlyingPrice = this.quote.underlyingPrice ?: 0.0,
        vega = this.quote.vega ?: 0.0,
        volatility = this.quote.volatility ?: 0.0,

        contractType = this.reference.contractType ?: "Unknown",
        daysToExpiration = this.reference.daysToExpiration ?: 0,
        deliverables = this.reference.deliverables ?: "Unknown",
        description = this.reference.description ?: "Unknown",
        exchange = this.reference.exchange ?: "Unknown",
        exchangeName = this.reference.exchangeName ?: "Unknown",
        exerciseType = this.reference.exerciseType ?: "Unknown",
        expirationDay = this.reference.expirationDay ?: 0,
        expirationMonth = this.reference.expirationMonth ?: 0,
        expirationType = this.reference.expirationType ?: "Unknown",
        expirationYear = this.reference.expirationYear ?: 0,
        isPennyPilot = this.reference.isPennyPilot ?: false,
        lastTradingDay = this.reference.lastTradingDay ?: 0L,
        multiplier = this.reference.multiplier ?: 0.0,
        settlementType = this.reference.settlementType ?: "Unknown",
        strikePrice = this.reference.strikePrice ?: 0.0,
        underlying = this.reference.underlying ?: "Unknown"
    )
}

