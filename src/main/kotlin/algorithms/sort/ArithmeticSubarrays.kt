package algorithms.sort

fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    val result = mutableListOf<Boolean>()
    for (i in l.indices) {
        val sliced = nums.sliceArray(l[i]..r[i])
        sliced.sort()
        val diff = sliced[1] - sliced[0]
        var flag = true
        for (j in 2 until sliced.size)
            if (sliced[j] - sliced[j - 1] != diff) {
                result.add(false)
                flag = false
                break
            }
        if (flag) result.add(true)
    }
    return result.toList()
}
