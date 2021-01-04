package algorithms.graph.dfs

// 200. Number of Islands

fun numIslands(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val visited = Array(m) { Array(n) { false } }
    var count = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visited[i][j] && grid[i][j] == '1') {
                dfs(i, j, grid, visited)
                count++
            }
        }
    }
    return count
}

fun dfs(i: Int, j: Int, grid: Array<CharArray>, visited: Array<Array<Boolean>>) {
    if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size) {
        return
    }
    if (visited[i][j] || grid[i][j] == '0') {
        return
    }
    visited[i][j] = true
    dfs(i + 1, j, grid, visited)
    dfs(i - 1, j, grid, visited)
    dfs(i, j + 1, grid, visited)
    dfs(i, j - 1, grid, visited)
}
