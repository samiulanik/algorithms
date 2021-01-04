package algorithms.graph.dfs

// 1319. Number of Operations to Make Network Connected

fun makeConnected(n: Int, connections: Array<IntArray>): Int {
    if (connections.size < n - 1) return -1

    val adjMap = mutableMapOf<Int, MutableList<Int>>()
    (0 until n).forEach {
        adjMap[it] = mutableListOf()
    }
    connections.forEach {
        adjMap[it[0]]?.add(it[1])
        adjMap[it[1]]?.add(it[0])
    }
    val visited = mutableMapOf<Int, Boolean>()
    (0 until n).forEach {
        visited[it] = false
    }
    var connectedCount = 0
    (0 until n).forEach {
        if (!visited[it]!!) {
            dfs(it, adjMap, visited)
            connectedCount++
        }
    }
    if (connectedCount == 1) return 0
    return connectedCount - 1
}

fun dfs(source: Int, adjMap: MutableMap<Int, MutableList<Int>>, visited: MutableMap<Int, Boolean>) {
    if (visited[source]!!) return
    visited[source] = true
    adjMap[source]?.forEach {
        if (!visited[it]!!)
            dfs(it, adjMap, visited)
    }
}
