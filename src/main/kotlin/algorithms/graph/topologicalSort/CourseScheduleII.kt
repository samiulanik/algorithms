package algorithms.graph.topologicalSort

// 210. Course Schedule II

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val result = courseScheduleTopSort(numCourses, prerequisites)
    return if (result.size == numCourses) result.toIntArray() else emptyArray<Int>().toIntArray()
}
