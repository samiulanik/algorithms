package algorithms.graph.bfs
// 127. Word Ladder

import java.util.LinkedList
import java.util.Queue

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val queue: Queue<String> = LinkedList()
    val wordSet = wordList.toHashSet()
    val visited = mutableSetOf<String>()
    var level = 1
    val options = ('a'..'z').toSet()

    queue.add(beginWord)

    while (queue.isNotEmpty()) {
        val size = queue.size
        (1..size).forEach { _ ->
            val current = queue.poll()
            visited.add(current)
            val neighbors = getNeighbors(current, wordSet, options)
            if (neighbors.contains(endWord)) return level + 1
            neighbors.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        level++
    }
    return 0
}
