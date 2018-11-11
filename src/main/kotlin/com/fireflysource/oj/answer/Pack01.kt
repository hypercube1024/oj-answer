package com.fireflysource.oj.answer

/**
 * @author Pengtao Qiu
 */
fun select(goods: IntArray, max: Int): Int {
    fun selectGood(i: Int, remain: Int): Int {
        if (i == 0) return if (remain > goods[i]) goods[i] else 0

        val put = if (remain > goods[i]) {
            selectGood(i - 1, remain - goods[i]) + goods[i]
        } else 0

        val notPut = selectGood(i - 1, remain)
        return if (put > notPut) put else notPut
    }
    return selectGood(goods.lastIndex, max)
}

fun main(args: Array<String>) {
    println(select(intArrayOf(50, 42, 9, 15, 105, 63, 14, 30), 188))
}