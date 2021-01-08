package algorithms.array

// 957. Prison Cells After N Days

fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
    val temp = IntArray(8) { 0 }
    var current = cells
    (0..(N - 1) % 14).forEach { _ ->
        for (i in 0 until 7) {
            if (i == 0 || i == 7) {
                temp[i] = 0
            } else if ((current[i - 1] == 0 && current[i + 1] == 0) || (current[i - 1] == 1 && current[i + 1] == 1)) {
                temp[i] = 1
            } else {
                temp[i] = 0
            }
        }
        current = temp.clone()
    }
    return current
}

fun main() {
    println(prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).toList())
}
