package algorithms.array
import java.util.Arrays

// 15. 3Sum

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (nums.size < 3) {
        return result
    }

    Arrays.sort(nums)
    for (i in nums.indices) {
        if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    while (left + 1 < right && nums[left] == nums[left + 1]) left++
                    while (left < right - 1 && nums[right] == nums[right - 1]) right--
                    left++
                    right--
                }
                sum < 0 -> left++
                else -> right--
            }
        }
    }
    return result
}
