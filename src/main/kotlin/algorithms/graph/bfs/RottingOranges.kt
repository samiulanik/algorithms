package algorithms.graph.bfs

import java.util.LinkedList
import java.util.Queue
import kotlin.Pair

// 994. Rotting Oranges

fun orangesRotting(grid: Array<IntArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var freshCount = 0
    val positions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    val m = grid.size
    val n = grid[0].size

    for (i in 0 until m) {
        for (j in 0 until n) {
            when (grid[i][j]) {
                2 -> queue.add(kotlin.Pair(i, j))
                1 -> freshCount++
            }
        }
    }

    if (freshCount == 0) return 0

    var res = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (k in 0 until size) {
            val current = queue.poll()
            positions.forEach {
                val x = current.first + it.first
                val y = current.second + it.second
                if (x in 0 until m && y in 0 until n && grid[x][y] == 1) {
                    grid[x][y] = 2
                    queue.offer(Pair(x, y))
                    freshCount--
                }
            }
        }
        res++
    }

    return if (freshCount > 0) -1 else res - 1
}
