package algorithms.stock

// 122. Best Time to Buy and Sell Stock II

class BestTimeToBuyAndSellStockII {

    fun maxProfit(prices: IntArray): Int {
        var max = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - prices[i - 1]
            if (profit > 0) max += profit
        }
        return max
    }
}
