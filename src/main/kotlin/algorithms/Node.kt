package algorithms

data class Node(
    val id: Int,
    var visited: Boolean = false,
    var pred: Node? = null,
    var distance: Int = 0,
    val adjList: MutableList<Node> = mutableListOf(),
    var nonAdjList: Set<Int> = setOf()
)
