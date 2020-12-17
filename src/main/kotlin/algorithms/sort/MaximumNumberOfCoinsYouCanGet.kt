package algorithms.sort

fun maxCoins(piles: IntArray): Int {
    piles.sort()
    val pilesCount = piles.size / 3
    var ans = 0
    for (i in piles.size - 2 downTo pilesCount step 2) ans += piles[i]
    return ans
}
