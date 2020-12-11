package algorithms.string

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    if (strs.size == 1) {
        return listOf(listOf(strs[0]))
    }

    val isAdded = mutableMapOf<Int, Boolean>()
    val frequencyCountMap = mutableMapOf<Int, Map<Char, Int>>()
    (strs.indices).forEach {
        isAdded[it] = false
        frequencyCountMap[it] = strs[it].groupingBy { v -> v }.eachCount()
    }
    val result = mutableListOf<List<String>>()

    for (i in strs.indices) {
        val toAdd = mutableListOf<String>()
        val first = strs[i]
        if (!isAdded[i]!!) {
            toAdd.add(first)
            isAdded[i] = true
        } else {
            continue
        }
        for (j in i + 1 until strs.size) {
            val second = strs[j]
            if (frequencyCountMap[i] == frequencyCountMap[j] && !isAdded[j]!!) {
                toAdd.add(second)
                isAdded[j] = true
            }
        }
        result.add(toAdd)
    }
    return result.toList()
}

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}
