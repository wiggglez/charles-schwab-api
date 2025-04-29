package com.github.wigggy.charles_schwab_api.data_objs.responses

import com.github.wigggy.charles_schwab_api.data_objs.Option
import com.github.wigggy.charles_schwab_api.data_objs.OptionChain
import com.github.wigggy.charles_schwab_api.data_objs.OptionDeliverable
import com.github.wigggy.charles_schwab_api.data_objs.Underlying

internal data class OptionChainResponse(
    val symbol: String,
    val status: String,
    val underlying: Underlying,
    val strategy: String,
    val interval: Double,
    val isDelayed: Boolean,
    val isIndex: Boolean,
    val interestRate: Double,
    val underlyingPrice: Double,
    val volatility: Double,
    val daysToExpiration: Double,
    val numberOfContracts: Int,
    val assetMainType: String,
    val assetSubType: String,
    val isChainTruncated: Boolean,
    val callExpDateMap: Map<String, Map<String, List<OptionResponse>>>,         // TODO should not be List<Option> just Option
    val putExpDateMap: Map<String, Map<String, List<OptionResponse>>>
)



internal data class OptionResponse(
    val putCall: String,
    val symbol: String,
    val description: String,
    val exchangeName: String,
    val bid: Double,
    val ask: Double,
    val last: Double,
    val mark: Double,
    val bidSize: Int,
    val askSize: Int,
    val bidAskSize: String,
    val lastSize: Int,
    val highPrice: Double,
    val lowPrice: Double,
    val openPrice: Double,
    val closePrice: Double,
    val totalVolume: Int,
    val tradeTimeInLong: Long,
    val quoteTimeInLong: Long,
    val netChange: Double,
    val volatility: Double,
    val delta: Double,
    val gamma: Double,
    val theta: Double,
    val vega: Double,
    val rho: Double,
    val openInterest: Int,
    val timeValue: Double,
    val theoreticalOptionValue: Double,
    val theoreticalVolatility: Double,
    val optionDeliverablesList: List<OptionDeliverable>,
    val strikePrice: Double,
    val expirationDate: String,
    val daysToExpiration: Int,
    val expirationType: String,
    val lastTradingDay: Long,
    val multiplier: Double,
    val settlementType: String,
    val deliverableNote: String,
    val percentChange: Double,
    val markChange: Double,
    val markPercentChange: Double,
    val intrinsicValue: Double,
    val extrinsicValue: Double,
    val optionRoot: String,
    val exerciseType: String,
    val high52Week: Double,
    val low52Week: Double,
    val nonStandard: Boolean,
    val pennyPilot: Boolean,
    val inTheMoney: Boolean,
    val mini: Boolean
)



internal fun OptionResponse.toOption(): Option {
    return Option(
        putCall = this.putCall,
        symbol = this.symbol,
        description = this.description,
        exchangeName = this.exchangeName,
        bid = this.bid * 100,
        ask = this.ask * 100,
        last = this.last * 100,
        mark = this.mark * 100,
        bidSize = this.bidSize,
        askSize = this.askSize,
        bidAskSize = this.bidAskSize,
        lastSize = this.lastSize,
        highPrice = this.highPrice * 100,
        lowPrice = this.lowPrice * 100,
        openPrice = this.openPrice * 100,
        closePrice = this.closePrice * 100,
        totalVolume = this.totalVolume,
        tradeTimeInLong = this.tradeTimeInLong,
        quoteTimeInLong = this.quoteTimeInLong,
        netChange = this.netChange * 100,
        volatility = this.volatility,
        delta = this.delta,
        gamma = this.gamma,
        theta = this.theta,
        vega = this.vega,
        rho = this.rho,
        openInterest = this.openInterest,
        timeValue = this.timeValue * 100,
        theoreticalOptionValue = this.theoreticalOptionValue * 100,
        theoreticalVolatility = this.theoreticalVolatility,
        optionDeliverablesList = this.optionDeliverablesList,
        strikePrice = this.strikePrice,
        expirationDate = this.expirationDate,
        daysToExpiration = this.daysToExpiration,
        expirationType = this.expirationType,
        lastTradingDay = this.lastTradingDay,
        multiplier = this.multiplier,
        settlementType = this.settlementType,
        deliverableNote = this.deliverableNote,
        percentChange = this.percentChange,
        markChange = this.markChange * 100,
        markPercentChange = this.markPercentChange,
        intrinsicValue = this.intrinsicValue * 100,     // check
        extrinsicValue = this.extrinsicValue * 100,     // check
        optionRoot = this.optionRoot,
        exerciseType = this.exerciseType,
        high52Week = this.high52Week * 100,
        low52Week = this.low52Week * 100,
        nonStandard = this.nonStandard,
        pennyPilot = this.pennyPilot,
        inTheMoney = this.inTheMoney,
        mini = this.mini
    )
}

internal fun OptionChainResponse.convertToOptionChain(): OptionChain {
    
    val newCMap = mutableMapOf<String, Map<String, Option>>()
    val newPMap = mutableMapOf<String, Map<String, Option>>()
    val expDates = this.callExpDateMap.keys
    
    for (exp in expDates){
        val csMap = this.callExpDateMap[exp]?.keys
        val psMap = this.putExpDateMap[exp]?.keys
        val newCallSMap = mutableMapOf<String, Option>()
        val newPutSMap = mutableMapOf<String, Option>()
        for (s in csMap!!){
            val co = this.callExpDateMap[exp]!![s]!![0].toOption()
            newCallSMap.put(s, co)
        }
        newCMap.put(exp, newCallSMap)
        for (s in psMap!!){
            val po = this.putExpDateMap[exp]!![s]!![0].toOption()
            newPutSMap.put(s, po)
        }
        newPMap.put(exp, newPutSMap)
    }
    
    return OptionChain(
        symbol = this.symbol,
        status = this.status,
        underlying = this.underlying,
        strategy = this.strategy,
        interval = this.interval,
        isDelayed = this.isDelayed,
        isIndex = this.isIndex,
        interestRate = this.interestRate,
        underlyingPrice = this.underlyingPrice,
        volatility = this.volatility,
        daysToExpiration = this.daysToExpiration,
        numberOfContracts = this.numberOfContracts,
        assetMainType = this.assetMainType,
        assetSubType = this.assetSubType,
        isChainTruncated = this.isChainTruncated,
        callExpDateMap = newCMap,
        putExpDateMap = newPMap
    )
}

