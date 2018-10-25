package com.fireflysource.oj.answer


/**
 * 2. Add Two Numbers
 */
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val ret = ListNode(0)
    var (curNode, curL1, curL2) = arrayOf(ret, l1, l2)
    var carry = 0
    while (true) {
        val l1Val = curL1?.`val` ?: 0
        val l2Val = curL2?.`val` ?: 0
        val sum = l1Val + l2Val + carry
        if (sum >= 10) {
            val mod = sum % 10
            curNode?.`val` = mod
            carry = 1

            curL1 = curL1?.next
            curL2 = curL2?.next
            if (curL1 == null && curL2 == null) {
                curNode?.next = ListNode(1)
                break
            } else {
                curNode?.next = ListNode(0)
                curNode = curNode?.next
            }
        } else {
            curNode?.`val` = sum
            carry = 0

            curL1 = curL1?.next
            curL2 = curL2?.next
            if (curL1 == null && curL2 == null) {
                break
            } else {
                curNode?.next = ListNode(0)
                curNode = curNode?.next
            }
        }

    }
    return ret
}

/**
 * 3. Longest Substring Without Repeating Characters
 */
fun lengthOfLongestSubstring(s: String): Int {
    val store = mutableMapOf<Char, Int>() // current index of character
    var (ret, idx) = intArrayOf(0, 0)
    for (i in 0..s.lastIndex) {
        val c = s[i]
        if (store.containsKey(c)) {
            idx = Math.max(store[c]!!, idx)
        }
        ret = Math.max(i - idx + 1, ret)
        store[c] = i + 1
    }
    return ret
}

/**
 * 4. Median of Two Sorted Arrays
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val ret = IntArray(nums1.size + nums2.size)
    var (idx1, idx2, i) = intArrayOf(0, 0, 0)
    while (idx1 < nums1.size && idx2 < nums2.size) {
        ret[i++] = if (nums1[idx1] < nums2[idx2]) nums1[idx1++] else nums2[idx2++]
    }
    while (idx1 < nums1.size) {
        ret[i++] = nums1[idx1++]
    }
    while (idx2 < nums2.size) {
        ret[i++] = nums2[idx2++]
    }

    return if (ret.size % 2 == 0) {
        val m = ret.size / 2
        (ret[m - 1] + ret[m]).toDouble() / 2
    } else {
        ret[ret.size / 2].toDouble()
    }
}

fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
    TODO("")
}

/**
 * 5. Longest Palindromic Substring
 */
fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
        return s
    }

    var maxLen = 0
    var ret = ""

    fun find(l: Int, h: Int) {
        var (low, high) = l to h
        while (low >= 0 && high <= s.lastIndex) {
            if (s[low] == s[high]) {
                val len = high - low + 1
                if (len > maxLen) {
                    maxLen = len
                    ret = s.substring(low, high + 1)
                }
                low--
                high++
            } else {
                break
            }
        }
    }

    for (i in 0..s.lastIndex) {
        find(i, i)
        find(i, i + 1)
    }
    return ret
}

/**
 * 6. ZigZag Conversion
 */
fun convert(s: String, numRows: Int): String {
    if (s.isEmpty() || numRows <= 1) {
        return s
    }

    val list = List(Math.min(numRows, s.length)) { StringBuilder() }
    var row = 0
    var descend = false
    for (c in s) {
        list[row].append(c)
        if (row == 0 || row == numRows - 1) {
            descend = !descend
        }
        row = if (descend) row + 1 else row - 1
    }
    return list.joinToString("")
}
