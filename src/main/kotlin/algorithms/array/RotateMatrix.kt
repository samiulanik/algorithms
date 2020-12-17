package algorithms.array

fun rotate(a: Array<IntArray>) {
    val m = a.size
    val n = a[0].size
    for (i in 0 until m) {
        for (j in i + 1 until n) {
            val temp = a[i][j]
            a[i][j] = a[j][i]
            a[j][i] = temp
        }
    }
    for (i in 0 until m) {
        for (j in 0 until m / 2) {
            val temp = a[i][j]
            a[i][j] = a[i][m - j - 1]
            a[i][m - j - 1] = temp
        }
    }
}
