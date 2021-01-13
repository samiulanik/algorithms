package algorithms.mapLookup

// 1497. Check If Array Pairs Are Divisible by k

fun canArrange(arr: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, Int>()
    arr.forEach {
        val rem = getRem(it, k)
        map[rem] = map.getOrDefault(rem, 0) + 1
    }
    val zero = map[0]
    if (zero != null && zero % 2 != 0) return false
    arr.forEach {
        val rem = getRem(it, k)
        val otherRem = k - rem
        if (rem != 0) {
            val count = map[otherRem] ?: return false
            if (count <= 0) return false
            map[otherRem] = count - 1
        }
    }
    return true
}

private fun getRem(it: Int, k: Int): Int {
    val rem = it % k
    return if (rem < 0) rem + k else rem
}

fun main() {
    println(canArrange(intArrayOf(-1, 1, -2, 2, -3, 3, -4, 4), 3))
}
