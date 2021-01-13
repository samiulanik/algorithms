package algorithms.graph.topologicalSort

// 207. Course Schedule

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val result = courseScheduleTopSort(numCourses, prerequisites)
    return result.size == numCourses
}
