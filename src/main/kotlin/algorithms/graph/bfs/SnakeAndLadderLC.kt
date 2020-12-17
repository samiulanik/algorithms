package algorithms.graph.bfs

import java.util.LinkedList
import java.util.Queue
// Leetcode

fun snakesAndLadders(board: Array<IntArray>): Int {
    val size = board.size
    val jumpMap = mutableMapOf<Int, Int>()
    val visitedMap = (1..size * size).map { it to false }.toMap().toMutableMap()

    val source = 1
    val destination = size * size
    var k = 1
    while (k <= size * size) {
        val row = size - 1 - (k - 1) / size
        val col = if ((k - 1) / size % 2 == 0) (k - 1) % size else size - 1 - (k - 1) % size
        if (board[row][col] != -1) jumpMap[k] = board[row][col]
        k++
    }
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(source)
    visitedMap[source] = true
    var level = 0
    while (queue.isNotEmpty()) {
        var queueSize = queue.size
        while (queueSize > 0) {
            val current = queue.poll()

            val adjSet = (1..6).filter { it + current <= destination }.map { current + it }.toHashSet()

            if (adjSet.contains(destination)) {
                println(destination)
                return level + 1
            }
            adjSet.forEach {
                val jump = jumpMap[it]
                if (jump != null) {
                    if (jump == destination) return level + 1
                    else if (!visitedMap[jump]!!) {
                        visitedMap[it] = true
                        visitedMap[jump] = true
                        queue.offer(jump)
                    }
                } else if (!visitedMap[it]!!) {
                    visitedMap[it] = true
                    queue.offer(it)
                }
            }
            queueSize--
        }
        level++
    }

    return -1
}
