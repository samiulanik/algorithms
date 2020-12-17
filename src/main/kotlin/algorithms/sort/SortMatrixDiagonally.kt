package algorithms.sort

fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val rowMax = mat.size
    val colMax = mat[0].size
    var visited = Array(rowMax) { Array(colMax) { false } }
    for (i in mat.indices) {
        for (j in mat[0].indices) {
            if (!visited[i][j]) {
                var x = i
                var y = j
                val list = mutableListOf<Int>()
                while (x < rowMax && y < colMax) {
                    visited[x][y] = true
                    list.add(mat[x][y])
                    x++
                    y++
                }
                list.sort()
                x = i
                y = j
                var z = 0
                while (x < rowMax && y < colMax) {
                    mat[x][y] = list[z]
                    x++
                    y++
                    z++
                }
            }
        }
    }
    return mat
}
