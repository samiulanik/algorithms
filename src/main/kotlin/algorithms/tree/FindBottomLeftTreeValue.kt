package algorithms.tree

import java.util.LinkedList
import java.util.Queue

fun findBottomLeftValue(root: TreeNode?): Int {
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    val finalList = mutableListOf<MutableList<Int>>()
    while (queue.isNotEmpty()) {
        var size = queue.size
        val list = mutableListOf<Int>()
        while (size > 0) {
            val current = queue.poll()
            list.add(current.`val`)
            if (current.left != null) queue.offer(current.left)
            if (current.right != null) queue.offer(current.right)
            size--
        }
        finalList.add(list)
    }
    return finalList[finalList.size - 1][0]
}
