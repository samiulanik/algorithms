package algorithms.tree

import java.util.LinkedList
import java.util.Queue

fun isEvenOddTree(root: TreeNode?): Boolean {
    if (root?.left == null && root?.right == null) {
        return true
    }
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    var level = 0

    while (queue.isNotEmpty()) {
        val levelNodes: MutableList<Int> = mutableListOf()
        var queueSize: Int = queue.size
        while (queueSize > 0) {
            val node: TreeNode = queue.remove()
            levelNodes.add(node.`val`)
            if (node.left != null) {
                queue.add(node.left)
            }
            if (node.right != null) {
                queue.add(node.right)
            }
            queueSize--
        }
        if (level % 2 == 1) {
            val result = isEvenList(levelNodes)
            if (!result) return false
        } else {
            val result = isOddList(levelNodes)
            if (!result) return false
        }
        level++
    }
    return true
}

fun isEvenList(list: MutableList<Int>): Boolean {
    if (list.size == 1)
        return if (list[list.size - 1] % 2 == 1) return true else false

    for (i in 0 until list.size - 1) {
        if (list[i] % 2 == 1) return false
        else if (list[i] <= list[i + 1]) return false
    }
    return if (list[list.size - 1] % 2 == 1) return true else false
}

fun isOddList(list: MutableList<Int>): Boolean {
    if (list.size == 1)
        return if (list[list.size - 1] % 2 == 0) return true else false

    for (i in 0 until list.size - 1) {
        if (list[i] % 2 == 0) return false
        else if (list[i] >= list[i + 1]) return false
    }
    return if (list[list.size - 1] % 2 == 0) return true else false
}
