package algorithms.tree

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs
import kotlin.math.max

fun maxAncestorDiff(root: TreeNode?): Int {
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    val finalList = mutableListOf<MutableList<TreeNode>>()
    val ancestorMap = mutableMapOf<TreeNode?, MutableList<Int>>()
    ancestorMap[root] = mutableListOf()
    while (queue.isNotEmpty()) {
        var size = queue.size
        val list = mutableListOf<TreeNode>()
        while (size > 0) {
            val current = queue.poll()
            list.add(current)
            if (current.left != null) {
                queue.offer(current.left)
                ancestorMap[current.left] = mutableListOf(current.`val`)
                ancestorMap[current]?.let { ancestorMap[current.left]?.addAll(it) }
            }
            if (current.right != null) {
                queue.offer(current.right)
                ancestorMap[current.right] = mutableListOf(current.`val`)
                ancestorMap[current]?.let { ancestorMap[current.right]?.addAll(it) }
            }
            size--
        }
        finalList.add(list)
    }
    var max = Int.MIN_VALUE
    for (i in finalList.indices) {
        for (j in finalList[i].indices) {
            ancestorMap[finalList[i][j]]?.forEach {
                max = max(max, abs(finalList[i][j].`val` - it))
            }
        }
    }
    return max
}
