package algorithms.array

import kotlin.math.floor

fun majorityElement(nums: IntArray): List<Int> {
    var canOne = 0
    var canTwo = 1
    var countOne = 0
    var countTwo = 0

    if (nums.size == 1) {
        return listOf(nums[0])
    }

    nums.forEach { num ->
        when {
            num == canOne -> countOne++
            num == canTwo -> countTwo++
            countOne == 0 -> {
                countOne = 1
                canOne = num
            }
            countTwo == 0 -> {
                countTwo = 1
                canTwo = num
            }
            else -> {
                countOne--
                countTwo--
            }
        }
    }

    return nums.filter { it in listOf(canOne, canTwo) }.groupingBy { it }.eachCount().filter { it.value > floor(nums.size / 3.0) }.keys.toList()
}

fun main() {
    println(majorityElement(intArrayOf(2, 3)))
}
