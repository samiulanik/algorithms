package algorithms.string

// 763. Partition Labels

fun partitionLabels(S: String): List<Int> {
    val charLastIndex = mutableMapOf<Char, Int>()
    val result = mutableListOf<Int>()
    S.forEachIndexed { index, element ->
        charLastIndex[element] = index
    }

    var start = 0
    var end = 0
    S.forEachIndexed { index, element ->
        val maxIndex = charLastIndex[element]!!
        end = end.coerceAtLeast(maxIndex)
        if (end == index) {
            result.add(end - start + 1)
            start = end + 1
        }
    }

    return result
}
