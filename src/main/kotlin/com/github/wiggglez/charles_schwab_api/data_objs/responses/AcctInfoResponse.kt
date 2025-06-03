package com.github.wiggglez.charles_schwab_api.data_objs.responses

import com.github.wiggglez.charles_schwab_api.data_objs.AccountInfo


internal data class AcctInfoResponse(
    val securitiesAccount: SecuritiesAccount
)

internal data class SecuritiesAccount(
    val accountNumber: String,
    val roundTrips: Int,
    val isDayTrader: Boolean,
    val isClosingOnlyRestricted: Boolean,
    val pfcbFlag: Boolean,
    val positions: List<CSPosition>,
    val initialBalances: IBalances,
    val currentBalances: CBalances,
    val projectedBalances: ProjectedBalances
)

data class CSPosition(
    val shortQuantity: Int,
    val averagePrice: Double,
    val currentDayProfitLoss: Double,
    val currentDayProfitLossPercentage: Double,
    val longQuantity: Int,
    val settledLongQuantity: Int,
    val settledShortQuantity: Int,
    val agedQuantity: Int,
    val instrument: CSInstrument,
    val marketValue: Double,
    val maintenanceRequirement: Double,
    val averageLongPrice: Double,
    val averageShortPrice: Double,
    val taxLotAverageLongPrice: Double,
    val taxLotAverageShortPrice: Double,
    val longOpenProfitLoss: Double,
    val shortOpenProfitLoss: Double,
    val previousSessionLongQuantity: Int,
    val previousSessionShortQuantity: Int,
    val currentDayCost: Double
)

data class CSInstrument(
    val cusip: String,
    val symbol: String,
    val description: String,
    val instrumentId: Long,
    val netChange: Double,
    val type: String
)

internal data class IBalances(
    val accruedInterest: Double,
    val availableFundsNonMarginableTrade: Double,
    val bondValue: Double,
    val buyingPower: Double,
    val cashBalance: Double,
    val cashAvailableForTrading: Double,
    val cashReceipts: Double,
    val dayTradingBuyingPower: Double,
    val dayTradingBuyingPowerCall: Double,
    val dayTradingEquityCall: Double,
    val equity: Double,
    val equityPercentage: Double,
    val liquidationValue: Double,
    val longMarginValue: Double,
    val longOptionMarketValue: Double,
    val longStockValue: Double,
    val maintenanceCall: Double,
    val maintenanceRequirement: Double,
    val margin: Double,
    val marginEquity: Double,
    val moneyMarketFund: Double,
    val mutualFundValue: Double,
    val regTCall: Double,
    val shortMarginValue: Double,
    val shortOptionMarketValue: Double,
    val shortStockValue: Double,
    val totalCash: Double,
    val isInCall: Boolean,
    val unsettledCash: Double,
    val pendingDeposits: Double,
    val marginBalance: Double,
    val shortBalance: Double,
    val accountValue: Double
)

internal data class CBalances(
    val availableFunds: Double,
    val availableFundsNonMarginableTrade: Double,
    val buyingPower: Double,
    val buyingPowerNonMarginableTrade: Double,
    val dayTradingBuyingPower: Double,
    val dayTradingBuyingPowerCall: Double,
    val equity: Double,
    val equityPercentage: Double,
    val longMarginValue: Double,
    val maintenanceCall: Double,
    val maintenanceRequirement: Double,
    val marginBalance: Double,
    val regTCall: Double,
    val shortBalance: Double,
    val shortMarginValue: Double,
    val sma: Double,
    val isInCall: Int,
    val stockBuyingPower: Double,
    val optionBuyingPower: Double
)

internal data class ProjectedBalances(
    val availableFunds: Double,
    val availableFundsNonMarginableTrade: Double,
    val buyingPower: Double,
    val buyingPowerNonMarginableTrade: Double,
    val dayTradingBuyingPower: Double,
    val dayTradingBuyingPowerCall: Double,
    val equity: Double,
    val equityPercentage: Double,
    val longMarginValue: Double,
    val maintenanceCall: Double,
    val maintenanceRequirement: Double,
    val marginBalance: Double,
    val regTCall: Double,
    val shortBalance: Double,
    val shortMarginValue: Double,
    val sma: Double,
    val isInCall: Int,
    val stockBuyingPower: Double,
    val optionBuyingPower: Double
)


