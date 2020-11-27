package algorithms

import java.util.LinkedList
import java.util.Queue

data class Node(
    val id: Int,
    var visited: Boolean = false,
    var pred: Node? = null,
    var distance: Int = 0,
    val adjList: MutableList<Node> = mutableListOf()
)

fun bfs(
    numberOfNodes: Int,
    numberOfEdges: Int,
    edges: Array<Array<Int>>,
    startNode: Int
): Array<Int> {
    val nodeMap = mutableMapOf<Int, Node>()
    (1..numberOfNodes).forEach {
        nodeMap[it] = Node(id = it)
    }

    edges.forEach {
        nodeMap[it[0]]?.adjList?.add(nodeMap[it[1]]!!)
        nodeMap[it[1]]?.adjList?.add(nodeMap[it[0]]!!)
    }

    val queue: Queue<Node> = LinkedList<Node>()

    queue.offer(nodeMap[startNode]!!)
    nodeMap[startNode]?.visited = true
    while (queue.isNotEmpty()) {
        val current = queue.remove()
        for (node in current.adjList) {
            if (!node.visited) {
                node.visited = true
                node.distance = current.distance + 6
                queue.offer(node)
            }
        }
    }

    val result = mutableListOf<Int>()
    (1..numberOfNodes).forEach {
        if (it != startNode) {
            result.add(if (nodeMap[it]?.distance == 0) -1 else nodeMap[it]?.distance!!)
        }
    }

    return result.toTypedArray()
}
