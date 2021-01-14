package algorithms.graph.bfs

// 433. Minimum Genetic Mutation

import java.util.LinkedList
import java.util.Queue

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    val bankSet = bank.toHashSet()
    val queue: Queue<String> = LinkedList()
    var level = 0
    val visited = mutableSetOf<String>()
    val options = setOf('A', 'G', 'C', 'T')
    queue.add(start)

    while (queue.isNotEmpty()) {
        val size = queue.size
        (1..size).forEach { _ ->
            val current = queue.poll()
            visited.add(current)
            val neighbors = getNeighbors(current, bankSet, options)
            if (neighbors.contains(end)) return level + 1
            neighbors.forEach {
                if (!visited.contains(it)) queue.add(it)
            }
        }
        level++
    }

    return -1
}
