package algorithms.graph.bfs
// 127. Word Ladder

import java.util.LinkedList
import java.util.Queue

fun getNeighbors(word: String, wordSet: Set<String>): Set<String> {
    val wordArray = word.toCharArray()
    val neighbours = mutableSetOf<String>()
    for (i in wordArray.indices) {
        val temp = wordArray[i]
        ('a'..'z').forEach {
            if (it != temp) {
                wordArray[i] = it
                val newWord = String(wordArray)
                if (wordSet.contains(newWord)) {
                    neighbours.add(newWord)
                }
            }
        }
        wordArray[i] = temp
    }
    return neighbours
}

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val queue: Queue<String> = LinkedList()
    val wordSet = wordList.toHashSet()
    val visited = mutableSetOf<String>()
    var level = 1

    queue.add(beginWord)

    while (queue.isNotEmpty()) {
        val size = queue.size
        (1..size).forEach { _ ->
            val current = queue.poll()
            visited.add(current)
            val neighbors = getNeighbors(current, wordSet)
            if (neighbors.contains(endWord)) return level + 1
            neighbors.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        level++
    }
    return 0
}
