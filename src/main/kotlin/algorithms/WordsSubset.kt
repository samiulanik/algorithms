package algorithms

import kotlin.math.max

fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
    val bFrequencyMap = ('a'..'z').map { it to 0 }.toMap().toMutableMap()
    B.forEach { b ->
        val frequencyMap = b.groupingBy { it }.eachCount()
        ('a'..'z').forEach {
            bFrequencyMap[it] = max(bFrequencyMap[it] ?: 0, frequencyMap[it] ?: 0)
        }
    }
    val result = mutableListOf<String>()

    A.forEach { a ->
        val frequencyMap = a.groupingBy { it }.eachCount()
        var flag = true
        ('a'..'z').forEach {
            if ((frequencyMap[it] != null && frequencyMap[it]!! < bFrequencyMap[it]!!) ||
                (frequencyMap[it] == null && bFrequencyMap[it]!! > 0)
            ) {
                flag = false
            }
        }
        if (flag)
            result.add(a)
    }
    return result.toList()
}
