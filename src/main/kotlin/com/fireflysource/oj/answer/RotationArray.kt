package com.fireflysource.oj.answer

import java.util.*

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

fun rotate(nums: IntArray, k: Int) {
    reverse(nums, 0, nums.lastIndex)
    reverse(nums, 0, k - 1)
    reverse(nums, k, nums.lastIndex)
}

fun reverse(nums: IntArray, start: Int, end: Int) {
    var s = start
    var e = end
    while (s < e) {
        val temp = nums[s]
        nums[s] = nums[e]
        nums[e] = temp
        s++
        e--
    }
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var m0 = m - 1
    var n0 = n - 1
    var last = m + n - 1
    while (m0 >= 0 && n0 >= 0) {
        if (nums1[m0] > nums2[n0]) {
            nums1[last--] = nums1[m0]
            nums1[m0--] = 0
        } else {
            nums1[last--] = nums2[n0--]
        }
    }
    while (m0 >= 0) {
        nums1[last--] = nums1[m0--]
    }
    while (n0 >= 0) {
        nums1[last--] = nums2[n0--]
    }
}

fun main(args: Array<String>) {
//    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
//    rotate(arr, 6)
//    println(Arrays.toString(arr))

    val arr = intArrayOf(1, 2, 3, 0, 0, 0)
    val arr2 = intArrayOf(2, 5, 6)
    merge(arr, 3, arr2, 3)
    println(Arrays.toString(arr))
}