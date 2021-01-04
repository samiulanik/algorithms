package algorithms.graph.dfs

// 79. Word Search

fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in board.indices) {
        for (j in board[0].indices) {
            val visited = Array(board.size) { Array(board[0].size) { false } }
            if (wordSearch(board, i, j, word, visited, 0)) return true
        }
    }
    return false
}

fun wordSearch(board: Array<CharArray>, i: Int, j: Int, word: String, visited: Array<Array<Boolean>>, pos: Int): Boolean {
    if (pos == word.length) return true
    if (i >= board.size || i < 0 || j >= board[0].size || j < 0) return false
    if (visited[i][j]) return false
    if (board[i][j] == word[pos]) {
        visited[i][j] = true
        val newPos = pos + 1
        if (wordSearch(board, i + 1, j, word, visited, newPos) ||
            wordSearch(board, i - 1, j, word, visited, newPos) ||
            wordSearch(board, i, j + 1, word, visited, newPos) ||
            wordSearch(board, i, j - 1, word, visited, newPos)
        ) {
            return true
        }
        // important part
        visited[i][j] = false
    }

    return false
}
