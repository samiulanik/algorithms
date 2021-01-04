package algorithms.graph.topologicalSort

data class Course(
    val id: Int,
    var inDegree: Int = 0,
    val neighbors: MutableList<Int> = mutableListOf(),
    var visited: Boolean = false
)
