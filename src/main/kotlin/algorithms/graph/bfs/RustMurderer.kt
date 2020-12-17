package algorithms.graph.bfs

import java.util.LinkedList
import java.util.Queue

// hacker rank
// TLE

fun rustMurdered(s: Int, n: Int, roads: Array<Array<Int>>): Array<Int> {
    val nodeMap = (1..n).map { it to Node(id = it) }.toMap()
    val allNodes = (1..n).toSet()
    nodeMap.forEach { it.value.nonAdjList = allNodes }
    roads.forEach {
        nodeMap[it[0]]?.nonAdjList = nodeMap[it[0]]?.nonAdjList!! subtract setOf(it[1])
        nodeMap[it[1]]?.nonAdjList = nodeMap[it[1]]?.nonAdjList!! subtract setOf(it[0])
    }

    val queue: Queue<Node> = LinkedList<Node>()

    queue.offer(nodeMap[s]!!)
    nodeMap[s]?.visited = true
    println(nodeMap)
    while (queue.isNotEmpty()) {
        val current = queue.remove()
        for (nodeId in current.nonAdjList) {
            val node = nodeMap[nodeId]!!
            if (!node.visited) {
                node.visited = true
                node.distance = current.distance + 1
                queue.offer(node)
            }
        }
    }
    val result = mutableListOf<Int>()
    (1..n).forEach {
        if (it != s) {
            result.add(nodeMap[it]?.distance!!)
        }
    }

    return result.toTypedArray()
}

fun main() {
    println(
        rustMurdered(
            1, 4,
            arrayOf(
                arrayOf(1, 2),
                arrayOf(2, 3),
                arrayOf(1, 4)
            )
        ).toString()
    )
}
