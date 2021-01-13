package algorithms.mapLookup

// 1010. Pairs of Songs With Total Durations Divisible by 60

fun numPairsDivisibleBy60(time: IntArray): Int {
    val remainderMap = mutableMapOf<Int, Int>()
    var count = 0
    time.forEach {
        count += if (it % 60 == 0) remainderMap.getOrDefault(0, 0) else remainderMap.getOrDefault(60 - it % 60, 0)
        remainderMap[it % 60] = remainderMap.getOrDefault(it % 60, 0) + 1
    }
    return count
}
