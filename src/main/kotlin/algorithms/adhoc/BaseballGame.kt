package algorithms.adhoc

// 682. Baseball Game

fun calPoints(ops: Array<String>): Int {
    val list = mutableListOf<Int>()
    for (i in ops.indices) {
        val value = ops[i].toIntOrNull()
        val size = list.size
        when {
            value != null -> list.add(value)
            ops[i] == "C" -> {
                if (size >= 1) list.removeAt(size - 1)
            }
            ops[i] == "D" -> {
                if (size >= 1) {
                    val last = list[size - 1]
                    list.add(last * 2)
                }
            }
            ops[i] == "+" -> {
                if (size >= 2) {
                    val last = list[size - 1]
                    val lastBefore = list[size - 2]
                    list.add(last + lastBefore)
                }
            }
        }
    }
    return list.sum()
}
