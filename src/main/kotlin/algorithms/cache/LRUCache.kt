package algorithms.cache

import java.util.Hashtable

// 146. LRU Cache

data class DLinkedNode(
    var key: Int = Int.MIN_VALUE,
    var value: Int = Int.MIN_VALUE,
    var pre: DLinkedNode? = null,
    var post: DLinkedNode? = null
)

class LRUCache(private val capacity: Int) {
    private val cache = Hashtable<Int, DLinkedNode>()
    private val head: DLinkedNode = DLinkedNode()
    private val tail: DLinkedNode = DLinkedNode()

    init {
        head.post = tail
        tail.pre = head
    }

    fun get(key: Int): Int {
        val node = cache[key]
            ?: return -1 // should raise exception here.

        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = cache[key]
        if (node == null) {
            val newNode = DLinkedNode(key, value)
            cache[key] = newNode
            addNode(newNode)
            if (cache.size > capacity) {
                val tail = popTail()
                cache.remove(tail!!.key)
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }

    private fun addNode(node: DLinkedNode) {
        node.pre = head
        node.post = head.post
        head.post!!.pre = node
        head.post = node
    }

    private fun removeNode(node: DLinkedNode?) {
        val pre = node!!.pre
        val post = node.post
        pre!!.post = post
        post!!.pre = pre
    }

    private fun moveToHead(node: DLinkedNode) {
        removeNode(node)
        addNode(node)
    }

    // pop the current tail.
    private fun popTail(): DLinkedNode? {
        val res = tail.pre
        removeNode(res)
        return res
    }
}
