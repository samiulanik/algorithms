package algorithms.sort

import kotlin.math.pow
import kotlin.math.sqrt

data class Point(val points: IntArray, val distance: Double)

fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
    val pointsWDist = points.map { Point(points = it, distance = sqrt(it[0].toDouble().pow(2.0) + it[1].toDouble().pow(2.0))) }
    val sortedPoints = pointsWDist.sortedBy { it.distance }
    return sortedPoints.subList(0, K - 1).map { it.points }.toTypedArray()
}
