package com.github.wiggglez.charles_schwab_api.data_objs

import com.github.wiggglez.charles_schwab_api.data_objs.responses.CSPosition

data class AccountInfo(
    val initialBalances: InitialBalances,
    val currentBalances: CurrentBalances,
    val openPositions: List<CSPosition>
)

data class InitialBalances(
    val buyingPower: Double,
    val cashBalance: Double,
    val cashAvailableForTrading: Double,
    val equity: Double,     // Value of Cash + Investments
    val totalCash: Double,
    val unsettledCash: Double,
    val pendingDeposits: Double,
    val accountValue: Double,
)

data class CurrentBalances(
    // Current Balances
    val availableFunds: Double,
    val buyingPower: Double,
    val equity: Double,
    val stockBuyingPower: Double,
    val optionBuyingPower: Double
)
