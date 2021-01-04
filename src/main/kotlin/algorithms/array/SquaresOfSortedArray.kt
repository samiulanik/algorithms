package algorithms.array

// 977. Squares of a Sorted Array

fun sortedSquares(nums: IntArray): IntArray {
    return nums.map { it * it }.sorted().toIntArray()
}
