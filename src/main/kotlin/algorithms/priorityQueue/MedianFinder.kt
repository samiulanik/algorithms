package algorithms.priorityQueue

import java.util.Collections
import java.util.PriorityQueue

class MedianFinder {
    private val maxQ = PriorityQueue<Int>(Collections.reverseOrder())
    private val minQ = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxQ.size == 0 || maxQ.peek() >= num) maxQ.add(num)
        else minQ.add(num)
        balance()
    }

    fun findMedian(): Double {
        return if (maxQ.size > minQ.size)
            maxQ.peek().toDouble()
        else ((maxQ.peek().toDouble() + minQ.peek().toDouble()) / 2.0)
    }

    fun remove(num: Int) {
        val minTop = minQ.peek()
        if (num >= minTop) minQ.remove(num) else maxQ.remove(num)
        balance()
    }

    private fun balance() {
        if (minQ.size > maxQ.size) maxQ.offer(minQ.poll())
        if (maxQ.size - minQ.size > 1) minQ.offer(maxQ.poll())
    }
}
