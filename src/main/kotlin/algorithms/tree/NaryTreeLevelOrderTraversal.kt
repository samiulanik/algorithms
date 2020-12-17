package algorithms.tree

import java.util.LinkedList
import java.util.Queue

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

fun levelOrder(root: Node?): List<List<Int>> {
    if (root == null) {
        return listOf(listOf())
    }
    val queue: Queue<Node> = LinkedList()
    queue.add(root)
    val finalList = mutableListOf<List<Int>>()

    while (queue.isNotEmpty()) {
        val list = mutableListOf<Int>()
        var size = queue.size
        while (size > 0) {
            val current = queue.poll()
            current.children.forEach {
                queue.offer(it)
            }
            list.add(current.`val`)
            size--
        }
        finalList.add(list.toList())
    }
    return finalList.toList()
}
