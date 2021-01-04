package algorithms.graph.topologicalSort

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val result = courseScheduleTopSort(numCourses, prerequisites)
    return result.size == numCourses
}
