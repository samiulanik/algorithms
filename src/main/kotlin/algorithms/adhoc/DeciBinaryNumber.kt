package algorithms.adhoc

fun minPartitions(n: String): Int {
    var max = 0
    for (i in n.indices) {
        val current = Character.getNumericValue(n[i])
        if (current > max) max = current
    }
    return max
}
