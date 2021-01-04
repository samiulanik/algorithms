package algorithms.graph.dfs

// 547. Number of Provinces

fun findCircleNum(M: Array<IntArray>): Int {
    val size = M.size
    val visited = BooleanArray(size) { false }
    var count = 0
    (0 until size).forEach {
        if (!visited[it]) {
            dfs(it, M, visited)
            count++
        }
    }

    return count
}

fun dfs(source: Int, M: Array<IntArray>, visited: BooleanArray) {
    if (visited[source]) return
    visited[source] = true
    for (i in M.indices) {
        if (M[source][i] == 1 && !visited[i]) {
            dfs(i, M, visited)
        }
    }
}
