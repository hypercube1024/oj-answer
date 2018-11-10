package com.fireflysource.oj.answer

/**
 * @author Pengtao Qiu
 */
const val max = 188
val goods = intArrayOf(50, 42, 9, 15, 105, 63, 14, 30)

fun make(i: Int, remain: Int): Int {
    if (i == 0) return if (remain > goods[i]) goods[i] else 0

    val putGood = if (remain > goods[i]) {
        make(i - 1, remain - goods[i]) + goods[i]
    } else 0

    val notPutGood = make(i - 1, remain)
    return if (putGood > notPutGood) putGood else notPutGood
}

fun main(args: Array<String>) {
    println(make(goods.lastIndex, max))
}