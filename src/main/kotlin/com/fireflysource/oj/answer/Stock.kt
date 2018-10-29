package com.fireflysource.oj.answer

/**
 * 121. Best Time to Buy and Sell Stock
 */
fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }

    var min = prices[0]
    var profit = 0
    for (price in prices) {
        if (price < min) {
            min = price
        } else {
            val p = price - min
            if (p > profit) {
                profit = p
            }
        }
    }
    return profit
}