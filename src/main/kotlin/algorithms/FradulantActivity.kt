package algorithms
// hacker rank TLE

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var counter = 0
    if (expenditure.size <= d) {
        return counter
    }

    for (i in expenditure.indices) {
        var slice = Array(d) { 0 }
        if (i + d - 1 < expenditure.size - 1) {
            slice = expenditure.sliceArray(i..i + d - 1)
        }
        var maiden = if (d % 2 == 1) kSelection(slice, 0, d - 1, d / 2 + 1) else (
            kSelection(slice, 0, d - 1, d / 2) +
                kSelection(slice, 0, d - 1, d / 2 - 1)
            ) / 2

        println(maiden)
        if (i + d < expenditure.size && expenditure[i + d] >= maiden * 2) {
            counter++
        }
    }
    return counter
}

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

fun main() {
    println(
        activityNotifications(arrayOf(10, 20, 30, 40, 50), 3)
        // kSelection(arrayOf(10, 20, 30), 0, 2, 2)
    )
}
