package algorithms.graph.bfs

data class Node(
    val id: Int,
    var visited: Boolean = false,
    var pred: Node? = null,
    var distance: Int = 0,
    val adjList: MutableList<Node> = mutableListOf(),
    var nonAdjList: Set<Int> = setOf()
)

fun getNeighbors(word: String, validSet: Set<String>, options: Set<Char>): Set<String> {
    val wordArray = word.toCharArray()
    val neighbours = mutableSetOf<String>()
    for (i in wordArray.indices) {
        val temp = wordArray[i]
        options.forEach {
            if (it != temp) {
                wordArray[i] = it
                val newMutation = String(wordArray)
                if (validSet.contains(newMutation)) {
                    neighbours.add(newMutation)
                }
            }
        }
        wordArray[i] = temp
    }
    return neighbours
}
