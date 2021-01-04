package algorithms.cache

// 460. LFU Cache

class LFUCache(private val cacheCapacity: Int) {
    private val cacheMap = mutableMapOf<Int, Int>()
    private val countMap = mutableMapOf<Int, Int>()
    private val countLinkMap = mutableMapOf<Int, LinkedHashSet<Int>>()
    private var min = 1

    fun get(key: Int): Int {
        val value = cacheMap[key] ?: return -1
        val count = countMap[key]!!

        val incCount = count + 1
        countMap[key] = incCount

        val currentLink = countLinkMap[count]!!
        currentLink.remove(key)
        if (currentLink.isEmpty()) countLinkMap.remove(count)

        val nextLink = countLinkMap[incCount]
        if (nextLink == null) {
            countLinkMap[incCount] = LinkedHashSet()
        }
        countLinkMap[incCount]?.add(key)

        if (count == min && countLinkMap[min] == null)
            min = incCount

        return value
    }

    fun put(key: Int, value: Int) {
        if (cacheCapacity <= 0) return
        if (cacheMap.containsKey(key)) {
            cacheMap[key] = value
            get(key)
        } else {
            if (cacheMap.size >= cacheCapacity) {
                val minSet = countLinkMap[min]!!
                val evict = minSet.iterator().next()
                minSet.remove(evict)
                if (minSet.isEmpty()) countLinkMap.remove(min)
                cacheMap.remove(evict)
                countMap.remove(evict)
            }
            cacheMap[key] = value
            countMap[key] = 1
            if (countLinkMap[1] == null) {
                countLinkMap[1] = LinkedHashSet()
            }
            countLinkMap[1]?.add(key)
            min = 1
        }
    }
}
