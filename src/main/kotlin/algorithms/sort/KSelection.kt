package algorithms.sort

import kotlin.math.abs

fun partition(nums: Array<Int>, low: Int, high: Int, offset: Int? = null): Int {
    var moveIndex = low
    val pivotValue = if (offset != null) abs(nums[high] - offset) else nums[high]
    for (i in low until high) {
        val num = if (offset != null) abs(nums[i] - offset) else nums[i]
        if (num >= pivotValue) {
            swap(nums, i, moveIndex)
            moveIndex++
        }
        if (num == pivotValue && offset != null) {
            if (nums[i] > nums[high]) {
                swap(nums, i, moveIndex)
                moveIndex++
            }
        }
    }
    swap(nums, moveIndex, high)
    return moveIndex
}

fun swap(nums: Array<Int>, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun kSelection(nums: Array<Int>, low: Int, high: Int, k: Int, offset: Int? = null): Int {
    val pivot = partition(nums, low, high, offset)
    if (pivot == k - 1) return nums[pivot]
    return if (pivot > k - 1) kSelection(nums, low, pivot - 1, k, offset) else kSelection(nums, pivot + 1, high, k, offset)
}
