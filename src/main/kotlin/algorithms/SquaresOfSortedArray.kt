package algorithms

fun sortedSquares(nums: IntArray): IntArray {
    return nums.map { it * it }.sorted().toIntArray()
}
