package algorithms.graph.dfs

// 212. Word Search II

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    return words.filter { exist(board, it) }
}
