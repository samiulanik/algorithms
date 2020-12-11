package algorithms.binarySearch

import java.util.Arrays

fun binarySearchModified(nums: IntArray, l: Int, r: Int, x: Int): Int {
    var left = l
    var right = r
    while (right >= left && right < nums.size) {
        val mid = (left + right) / 2
        if (nums[mid] >= x) right = mid - 1 else left = mid + 1
    }
    return l
}

fun triangleNumber(nums: IntArray): Int {
    var count = 0
    Arrays.sort(nums)
    for (i in 0 until nums.size - 2) {
        var k = i + 2
        var j = i + 1
        while (j < nums.size - 1 && nums[i] != 0) {
            k = binarySearchModified(nums, k, nums.size - 1, nums[i] + nums[j])
            count += k - j - 1
            j++
        }
    }
    return count
}

fun main() {
}
