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
