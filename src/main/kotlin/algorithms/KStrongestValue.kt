package algorithms

fun getStrongest(arr: IntArray, k: Int): IntArray {
    var flag = true
    for (i in 0..arr.size - 2) {
        if (arr[i] != arr[i + 1]) flag = false
    }
    if (flag) {
        return arr.sliceArray(0 until k)
    }
    val len = arr.size
    val nums = arr.toTypedArray()
    val kPos = len - ((len - 1) / 2)
    val maiden = kSelection(nums, 0, len - 1, kPos)
    kSelection(nums, 0, len - 1, k, maiden)
    return nums.sliceArray(0 until k).toIntArray()
}
