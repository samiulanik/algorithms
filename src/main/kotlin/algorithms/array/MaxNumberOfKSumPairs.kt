package algorithms.array

// 1679. Max Number of K-Sum Pairs

fun maxOperations(nums: IntArray, k: Int): Int {
    val map = nums.toList().groupingBy { it }.eachCount().toMutableMap()
    var count = 0
    for (i in nums.indices) {
        val remaining = k - nums[i]
        if (nums[i] == remaining && map[remaining] != null && map[remaining]!! > 1) {
            map[remaining] = map[remaining]!! - 2
            count++
        } else if (nums[i] != remaining && map[remaining] != null && map[remaining]!! > 0 && map[nums[i]] != null && map[nums[i]]!! > 0) {
            map[remaining] = map[remaining]!! - 1
            map[nums[i]] = map[nums[i]]!! - 1
            count++
        }
    }

    return count
}

fun main() {
    println(maxOperations(intArrayOf(2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2), 3))
}
