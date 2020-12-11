package algorithms.binarySearch

fun binarySearch(nums: IntArray, key: Int, low: Int, high: Int): Int {
    var first = low
    var last = high
    while (first <= last) {
        val mid = (first + last) / 2
        when {
            nums[mid] < key -> first = mid + 1
            nums[mid] > key -> last = mid - 1
            else -> return mid
        }
    }
    return -1
}
