package algorithms.stock

// 121. Best Time to Buy and Sell Stock

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var max = 0
        var min = prices[0]

        for (i in 1 until prices.size) {
            min = kotlin.math.min(min, prices[i])
            max = kotlin.math.max(max, prices[i] - min)
        }

        return max
    }
}
