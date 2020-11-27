package algorithms

import java.util.LinkedList
import java.util.Queue

fun quickestWayUp(ladders: Array<Array<Int>>, snakes: Array<Array<Int>>): Int {
    val nodeMap = (1..100).map { it to Node(id = it) }.toMap()
    val ladderMap = ladders.map { nodeMap[it[0]] to nodeMap[it[1]] }.toMap()
    val snakeMap = snakes.map { nodeMap[it[0]] to nodeMap[it[1]] }.toMap()
    val jumpMap = ladderMap + snakeMap
    val queue: Queue<Node> = LinkedList<Node>()
    val startNodeId = 1
    val endNodeId = 100
    nodeMap[1]?.visited = true
    queue.offer(nodeMap[startNodeId])

    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        (1..6).forEach {
            val adjId = it + currentNode.id
            if (adjId == endNodeId) {
                return currentNode.distance + 1
            } else if (adjId <= endNodeId) {
                val adjNode = nodeMap[adjId]
                val jumpNode = jumpMap[adjNode]
                if (jumpNode != null) {
                    if (jumpNode.id == endNodeId) {
                        return currentNode.distance + 1
                    }
                    if (!jumpNode.visited) {
                        currentNode.adjList.add(jumpNode)
                    }
                } else {
                    if (!adjNode?.visited!!)
                        currentNode.adjList.add(adjNode)
                }
            }
        }
        currentNode.adjList.forEach {
            if (!it.visited) {
                it.visited = true
                it.distance = currentNode.distance + 1
                queue.offer(it)
            }
        }
    }
    return -1
}
