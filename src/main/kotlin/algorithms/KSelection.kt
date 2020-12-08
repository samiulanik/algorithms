package algorithms

fun partition(nums: Array<Int>, low: Int, high: Int): Int {
    var moveIndex = low
    val pivotValue = nums[high]
    for (i in low until high) {
        if (nums[i] >= pivotValue) {
            swap(nums, i, moveIndex)
            moveIndex++
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

fun kSelection(nums: Array<Int>, low: Int, high: Int, k: Int): Int {
    val pivot = partition(nums, low, high)
    if (pivot == k - 1) return nums[pivot]
    return if (pivot > k - 1) kSelection(nums, low, pivot - 1, k) else kSelection(nums, pivot + 1, high, k)
}
