package com.github.wigggy.charles_schwab_api.data_objs.responses

import com.github.wigggy.charles_schwab_api.data_objs.StockQuote
import com.google.gson.annotations.SerializedName

internal data class StockQuoteResponse(
    @SerializedName("assetMainType") val assetMainType: String?,
    @SerializedName("assetSubType") val assetSubType: String?,
    @SerializedName("quoteType") val quoteType: String?,
    @SerializedName("realtime") val realtime: Boolean?,
    @SerializedName("ssid") val ssid: Long?,
    @SerializedName("symbol") val symbol: String?,
    @SerializedName("fundamental") val fundamental: Fundamental,
    @SerializedName("quote") val basicData: BasicData,
    @SerializedName("reference") val reference: Reference,
    @SerializedName("regular") val regular: MinimumData
)

internal data class Fundamental(
    @SerializedName("avg10DaysVolume") val avg10DaysVolume: Long?,
    @SerializedName("avg1YearVolume") val avg1YearVolume: Long?,
    @SerializedName("divAmount") val divAmount: Double?,
    @SerializedName("divFreq") val divFreq: Int?,
    @SerializedName("divPayAmount") val divPayAmount: Double?,
    @SerializedName("divYield") val divYield: Double?,
    @SerializedName("eps") val eps: Double?,
    @SerializedName("fundLeverageFactor") val fundLeverageFactor: Double?,
    @SerializedName("lastEarningsDate") val lastEarningsDate: String?,
    @SerializedName("peRatio") val peRatio: Double?
)

internal data class BasicData(
    @SerializedName("52WeekHigh") val week52High: Double?,
    @SerializedName("52WeekLow") val week52Low: Double?,
    @SerializedName("askMICId") val askMICId: String?,
    @SerializedName("askPrice") val askPrice: Double?,
    @SerializedName("askSize") val askSize: Int?,
    @SerializedName("askTime") val askTime: Long?,
    @SerializedName("bidMICId") val bidMICId: String?,
    @SerializedName("bidPrice") val bidPrice: Double?,
    @SerializedName("bidSize") val bidSize: Int?,
    @SerializedName("bidTime") val bidTime: Long?,
    @SerializedName("closePrice") val closePrice: Double?,
    @SerializedName("highPrice") val highPrice: Double?,
    @SerializedName("lastMICId") val lastMICId: String?,
    @SerializedName("lastPrice") val lastPrice: Double?,
    @SerializedName("lastSize") val lastSize: Int?,
    @SerializedName("lowPrice") val lowPrice: Double?,
    @SerializedName("mark") val mark: Double?,
    @SerializedName("markChange") val markChange: Double?,
    @SerializedName("markPercentChange") val markPercentChange: Double?,
    @SerializedName("netChange") val netChange: Double?,
    @SerializedName("netPercentChange") val netPercentChange: Double?,
    @SerializedName("openPrice") val openPrice: Double?,
    @SerializedName("postMarketChange") val postMarketChange: Double?,
    @SerializedName("postMarketPercentChange") val postMarketPercentChange: Double?,
    @SerializedName("quoteTime") val quoteTime: Long?,
    @SerializedName("securityStatus") val securityStatus: String?,
    @SerializedName("totalVolume") val totalVolume: Long?,
    @SerializedName("tradeTime") val tradeTime: Long?
)

internal data class Reference(
    @SerializedName("cusip") val cusip: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("exchangeName") val exchangeName: String?,
    @SerializedName("isHardToBorrow") val isHardToBorrow: Boolean?,
    @SerializedName("isShortable") val isShortable: Boolean?,
    @SerializedName("htbRate") val htbRate: Double?
)

internal data class MinimumData(
    @SerializedName("regularMarketLastPrice") val regularMarketLastPrice: Double?,
    @SerializedName("regularMarketLastSize") val regularMarketLastSize: Long?,
    @SerializedName("regularMarketNetChange") val regularMarketNetChange: Double?,
    @SerializedName("regularMarketPercentChange") val regularMarketPercentChange: Double?,
    @SerializedName("regularMarketTradeTime") val regularMarketTradeTime: Long?
)

internal fun StockQuoteResponse.toStockQuote(): StockQuote {
    return StockQuote(
        assetMainType = this.assetMainType ?: "Unknown",
        assetSubType = this.assetSubType ?: "Unknown",
        quoteType = this.quoteType ?: "Unknown",
        realtime = this.realtime ?: false,
        ssid = this.ssid ?: 0L,
        symbol = this.symbol ?: "Unknown",

        avg10DaysVolume = this.fundamental.avg10DaysVolume ?: 0L,
        avg1YearVolume = this.fundamental.avg1YearVolume ?: 0L,
        divAmount = this.fundamental.divAmount ?: 0.0,
        divFreq = this.fundamental.divFreq ?: 0,
        divPayAmount = this.fundamental.divPayAmount ?: 0.0,
        divYield = this.fundamental.divYield ?: 0.0,
        eps = this.fundamental.eps ?: 0.0,
        fundLeverageFactor = this.fundamental.fundLeverageFactor ?: 0.0,
        lastEarningsDate = this.fundamental.lastEarningsDate ?: "Unknown",
        peRatio = this.fundamental.peRatio ?: 0.0,

        week52High = this.basicData.week52High ?: 0.0,
        week52Low = this.basicData.week52Low ?: 0.0,
        askMICId = this.basicData.askMICId ?: "Unknown",
        askPrice = this.basicData.askPrice ?: 0.0,
        askSize = this.basicData.askSize ?: 0,
        askTime = this.basicData.askTime ?: 0L,
        bidMICId = this.basicData.bidMICId ?: "Unknown",
        bidPrice = this.basicData.bidPrice ?: 0.0,
        bidSize = this.basicData.bidSize ?: 0,
        bidTime = this.basicData.bidTime ?: 0L,
        closePrice = this.basicData.closePrice ?: 0.0,
        highPrice = this.basicData.highPrice ?: 0.0,
        lastMICId = this.basicData.lastMICId ?: "Unknown",
        lastPrice = this.basicData.lastPrice ?: 0.0,
        lastSize = this.basicData.lastSize ?: 0,
        lowPrice = this.basicData.lowPrice ?: 0.0,
        mark = this.basicData.mark ?: 0.0,
        markChange = this.basicData.markChange ?: 0.0,
        markPercentChange = this.basicData.markPercentChange ?: 0.0,
        netChange = this.basicData.netChange ?: 0.0,
        netPercentChange = this.basicData.netPercentChange ?: 0.0,
        openPrice = this.basicData.openPrice ?: 0.0,
        postMarketChange = this.basicData.postMarketChange ?: 0.0,
        postMarketPercentChange = this.basicData.postMarketPercentChange ?: 0.0,
        quoteTime = this.basicData.quoteTime ?: 0L,
        securityStatus = this.basicData.securityStatus ?: "Unknown",
        totalVolume = this.basicData.totalVolume ?: 0L,
        tradeTime = this.basicData.tradeTime ?: 0L,

        cusip = this.reference.cusip ?: "Unknown",
        description = this.reference.description ?: "Unknown",
        exchange = this.reference.exchange ?: "Unknown",
        exchangeName = this.reference.exchangeName ?: "Unknown",
        isHardToBorrow = this.reference.isHardToBorrow ?: false,
        isShortable = this.reference.isShortable ?: false,
        htbRate = this.reference.htbRate ?: 0.0,

        regularMarketLastPrice = this.regular.regularMarketLastPrice ?: 0.0,
        regularMarketLastSize = this.regular.regularMarketLastSize ?: 0L,
        regularMarketNetChange = this.regular.regularMarketNetChange ?: 0.0,
        regularMarketPercentChange = this.regular.regularMarketPercentChange ?: 0.0,
        regularMarketTradeTime = this.regular.regularMarketTradeTime ?: 0L
    )
}
