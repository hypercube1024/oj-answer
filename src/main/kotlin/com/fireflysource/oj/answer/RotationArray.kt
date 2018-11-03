package com.fireflysource.oj.answer

/**
 * @author Pengtao Qiu
 */
fun searchRatationArray(n: Int, array: IntArray): Int {
    var left = 0
    var right = array.lastIndex
    while (left <= right) {
        val middle = (left + right) / 2
        if (array[middle] == n) {
            return middle
        }
        if (array[middle] > array[left]) {
            if (array[left] <= n && n <= array[middle]) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        } else {
            if (array[middle] <= n && n <= array[right]) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }
    }
    return -1
}