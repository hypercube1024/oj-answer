package com.fireflysource.oj.answer

/**
 * 122. Best Time to Buy and Sell Stock
 */
fun maxProfit(prices: IntArray): Int {
    val n = 2
    val buy = Array(n) { Integer.MIN_VALUE }
    val sell = Array(n) { 0 }

    for (p in prices) {
        buy[0] = Math.max(buy[0], -p)
        sell[0] = Math.max(sell[0], buy[0] + p)

        for (i in 1..(n - 1)) {
            buy[i] = Math.max(buy[i], sell[i - 1] - p)
            sell[i] = Math.max(sell[i], buy[i] + p)
        }
    }
    return sell[n - 1]
}