package com.fireflysource.oj.answer

/**
 * @author Pengtao Qiu
 */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findTilt(root: TreeNode?): Int {
    var tilt = 0
    fun traverse(curNode: TreeNode?): Int {
        if (curNode == null) {
            return 0
        }

        val left = traverse(curNode.left)
        val right = traverse(curNode.right)
        tilt += Math.abs(left - right)
        return left + right + curNode.`val`
    }

    traverse(root)
    return tilt
}

fun isBalanced(root: TreeNode?): Boolean {
    fun getMaxDepth(node: TreeNode?): Int {
        if (node == null) return 0

        val left = getMaxDepth(node.left)
        val right = getMaxDepth(node.right)
        if (left == Int.MIN_VALUE || right == Int.MIN_VALUE || Math.abs(left - right) > 1) {
            return Int.MIN_VALUE
        }
        return Math.max(left, right) + 1
    }
    return getMaxDepth(root) != Int.MIN_VALUE
}

fun main(args: Array<String>) {
    val root = TreeNode(1)
    root.right = TreeNode(3)
    root.right?.left = TreeNode(2)
    isBalanced(root)
}