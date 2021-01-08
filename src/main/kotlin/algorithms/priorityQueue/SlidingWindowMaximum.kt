package algorithms.priorityQueue

import java.util.Collections
import java.util.PriorityQueue

// 239. Sliding Window Maximum

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    val list = mutableListOf<Int>()
    for (i in 0 until k) {
        pq.add(nums[i])
    }
    list.add(pq.peek())
    for (i in k until nums.size) {
        pq.remove(nums[i - k])
        pq.offer(nums[i])
        list.add(pq.peek())
    }

    return list.toIntArray()
}
