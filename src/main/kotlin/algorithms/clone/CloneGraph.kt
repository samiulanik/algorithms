package algorithms.clone

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.ArrayList

// 133. Clone Graph

class CloneGraph {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList()
    }

    fun cloneGraph(root: Node?): Node? {
        if (root == null) return root

        val map = mutableMapOf<Node, Node>()
        val queue: Queue<Node> = LinkedList()
        val copyRoot = Node(root.`val`)
        map[root] = copyRoot
        queue.add(root)

        while (!queue.isEmpty()) {
            val qNode = queue.remove()
            val qCopyNode = map[qNode]
            qNode.neighbors.forEach {
                if (!map.containsKey(it)) {
                    val copyN = Node(it?.`val`!!)
                    map[it] = copyN
                    qCopyNode?.neighbors?.add(copyN)
                    queue.add(it)
                } else {
                    qCopyNode?.neighbors?.add(map[it])
                }
            }
        }

        return copyRoot
    }
}
