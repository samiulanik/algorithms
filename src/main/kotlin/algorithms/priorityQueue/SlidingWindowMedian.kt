package algorithms.priorityQueue

// 480. Sliding Window Median

fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    val medianFinder = MedianFinder()
    val result = mutableListOf<Double>()
    for (i in nums.indices) {
        medianFinder.addNum(nums[i])
        if (i >= k) medianFinder.remove(nums[i - k])
        if (i >= k - 1) result.add(medianFinder.findMedian())
    }
    return result.toDoubleArray()
}

fun main() {
    // expected: 1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000
    medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).forEach { println(it) }
}
