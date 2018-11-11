package com.fireflysource.oj.answer

/**
 * @author Pengtao Qiu
 */
fun reverse(head: ListNode?): ListNode? {
    var reversedHead: ListNode? = null
    var currentNode: ListNode? = head
    var prevNode: ListNode? = null

    while (currentNode != null) {
        val nextNode = currentNode.next
        if (nextNode == null) {
            reversedHead = currentNode
        }
        currentNode.next = prevNode
        prevNode = currentNode
        currentNode = nextNode
    }
    return reversedHead
}

fun printLinkedList(head: ListNode?) {
    head?.foreach { print("${it.`val`}, ") }
    println()
}

inline fun ListNode.foreach(currentNode: (n: ListNode) -> Unit) {
    var node: ListNode? = this
    while (node != null) {
        currentNode.invoke(node)
        node = node.next
    }
}

fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true

    // move reference to middle position
    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    val mid = if (fast != null) slow?.next else slow

    val reversedHead = reverse(mid)

    var c = head
    var m = reversedHead
    while (m != null) {
        if (m.`val` != c?.`val`) return false

        m = m.next
        c = c.next
    }
    return true
}

fun main(args: Array<String>) {
//    val head = ListNode(1)
//    var currentNode: ListNode? = head
//    (2..5).forEach {
//        currentNode?.next = ListNode(it)
//        currentNode = currentNode?.next
//    }
//    printLinkedList(head)
//
//    val reversedHead = reverse(head)
//    printLinkedList(reversedHead)

    val head = ListNode(1)
    var c: ListNode? = head
    intArrayOf(2, 3, 4, 5, 4, 3, 2, 1).forEach {
        c?.next = ListNode(it)
        c = c?.next
    }
    printLinkedList(head)
    println(isPalindrome(head))
}