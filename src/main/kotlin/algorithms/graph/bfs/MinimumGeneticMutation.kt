package algorithms.graph.bfs

// 433. Minimum Genetic Mutation

import java.util.LinkedList
import java.util.Queue

fun getNextMutations(mutation: String, bankSet: Set<String>): Set<String> {
    val mutationArray = mutation.toCharArray()
    val neighbours = mutableSetOf<String>()
    for (i in mutationArray.indices) {
        val temp = mutationArray[i]
        mutableSetOf('A', 'C', 'G', 'T').forEach {
            if (it != temp) {
                mutationArray[i] = temp
                val newMutation = String(mutationArray)
                if (bankSet.contains(newMutation)) {
                    neighbours.add(newMutation)
                }
            }
        }
        mutationArray[i] = temp
    }
    return neighbours
}

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    val bankSet = bank.toHashSet()
    val queue: Queue<String> = LinkedList()
    var level = 0
    val visited = mutableSetOf<String>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val size = queue.size
        (1..size).forEach { _ ->
            val current = queue.poll()
            visited.add(current)
            val neighbors = getNextMutations(current, bankSet)
            if (neighbors.contains(end)) return level + 1
            neighbors.forEach {
                if (!visited.contains(it)) queue.add(it)
            }
        }
        level++
    }

    return -1
}
