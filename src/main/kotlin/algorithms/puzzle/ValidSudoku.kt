package algorithms.puzzle

// 36. Valid Sudoku

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val resultSet = mutableSetOf<String>()
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] != '.') {
                if (!resultSet.add("${board[i][j]} row $i") ||
                    !resultSet.add("${board[i][j]} column $j") ||
                    !resultSet.add("${board[i][j]} box ${i/3}${j/3}")
                )
                    return false
            }
        }
    }

    return true
}

fun isValidSudokuCell(value: Char, set: MutableSet<Char>): Boolean {
    if (value != '.') return set.add(value)
    return true
}

fun isValidSudokuSpaceOptimized(board: Array<CharArray>): Boolean {
    for (i in board.indices) {
        val rowSet = mutableSetOf<Char>()
        val colSet = mutableSetOf<Char>()
        for (j in board[0].indices) {
            if (!isValidSudokuCell(board[i][j], rowSet)) return false
            if (!isValidSudokuCell(board[j][i], colSet)) return false
            if (i % 3 == 0 && j % 3 == 0) {
                val boxSet = mutableSetOf<Char>()
                for (k in i until i + 3) {
                    for (l in j until j + 3) {
                        if (!isValidSudokuCell(board[k][l], boxSet)) return false
                    }
                }
            }
        }
    }

    return true
}
