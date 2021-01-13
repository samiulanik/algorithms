package algorithms.graph.topologicalSort

import java.util.LinkedList
import java.util.Queue

fun courseScheduleTopSort(numCourses: Int, prerequisites: Array<IntArray>): Set<Int> {
    val courseMap = (0 until numCourses).map { Course(it) }.associateBy { it.id }
    val result = mutableSetOf<Int>()
    prerequisites.forEach {
        val courseSource = courseMap[it[1]]!!
        courseSource.neighbors.add(it[0])
        val courseDest = courseMap[it[0]]!!
        courseDest.inDegree++
    }

    val queue: Queue<Course> = LinkedList()
    courseMap.values.filter { it.inDegree == 0 }.forEach { queue.offer(it) }

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        current.neighbors.forEach {
            val course = courseMap[it]!!
            course.inDegree--
            if (course.inDegree == 0) {
                queue.offer(course)
            }
        }
        result.add(current.id)
    }
    return result
}
