package com.fireflysource.oj.answer

/**
 * @author Pengtao Qiu
 */


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var (list1, list2) = arrayOf(l1, l2)
    if (list1 == null && list2 == null) {
        return null
    }

    val ret = ListNode(0)
    var currentNode = ret
    while (list1 != null && list2 != null) {
        val v1 = list1.`val`
        val v2 = list2.`val`
        val v = if (v1 < v2) {
            list1 = list1.next
            v1
        } else {
            list2 = list2.next
            v2
        }
        currentNode.`val` = v
        if (list1 != null || list2 != null) {
            currentNode.next = ListNode(0)
            currentNode = currentNode.next!!
        }
    }

    while (list1 != null) {
        val v1 = list1.`val`
        list1 = list1.next
        currentNode.`val` = v1
        if (list1 != null) {
            currentNode.next = ListNode(0)
            currentNode = currentNode.next!!
        }
    }

    while (list2 != null) {
        val v2 = list2.`val`
        list2 = list2.next
        currentNode.`val` = v2
        if (list2 != null) {
            currentNode.next = ListNode(0)
            currentNode = currentNode.next!!
        }
    }

    return ret
}