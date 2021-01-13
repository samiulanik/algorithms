package algorithms.twoPointer

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var i = 0
    var j = arr.size - 1
    while (j - i >= k) {
        val d1 = x - arr[i]
        val d2 = arr[j] - x
        when {
            d1 > d2 -> i++
            else -> j--
        }
    }

    return arr.slice(i..j).toList()
}
