package algorithms.graph.dfs

// hacker rank
fun maxRegion(grid: Array<Array<Int>>): Int {
    val m = grid.size
    val n = grid[0].size
    var maxConnected = 0

    val visited = Array(m) { Array(n) { false } }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (!visited[i][j] && grid[i][j] == 1) {
                val connectedList = mutableListOf<Int>()
                dfs(grid, visited, i, j, connectedList)
                maxConnected = maxConnected.coerceAtLeast(connectedList.size)
            }
        }
    }
    return maxConnected
}

fun dfs(grid: Array<Array<Int>>, visited: Array<Array<Boolean>>, i: Int, j: Int, list: MutableList<Int>) {
    if (i >= 0 &&
        j >= 0 &&
        i < grid.size &&
        j < grid[0].size &&
        grid[i][j] == 1 &&
        !visited[i][j]
    ) {
        visited[i][j] = true
        list.add(grid[i][j])
        dfs(grid, visited, i, j - 1, list)
        dfs(grid, visited, i, j + 1, list)
        dfs(grid, visited, i + 1, j - 1, list)
        dfs(grid, visited, i + 1, j, list)
        dfs(grid, visited, i + 1, j + 1, list)
        dfs(grid, visited, i - 1, j - 1, list)
        dfs(grid, visited, i - 1, j + 1, list)
        dfs(grid, visited, i - 1, j, list)
    }
}
/*
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
* */
fun main() {
    maxRegion(
        arrayOf(
            arrayOf(1, 1, 0, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(0, 0, 1, 0),
            arrayOf(1, 0, 0, 0)
        )
    )
}
