package algorithms.linkedlist

class KReverseList {
    fun reverseList(head: ListNode?, k: Int): ListNode? {
        if (k <= 1) return head
        var current = head
        var position = 1
        var currentRoot = head
        var isFirst = false
        var finalHead: ListNode? = null
        var prev: ListNode? = null
        while (current != null) {
            val next = current.next
            if (position % k == 0) {
                current.next = null
                val revRoot = reverse(currentRoot)
                if (prev != null) prev.next = revRoot
                if (!isFirst) {
                    finalHead = revRoot
                    isFirst = true
                }
                var node = revRoot
                while (node!!.next != null) node = node.next
                prev = node
                currentRoot = next
            }
            position++
            current = next
        }
        return finalHead
    }

    private fun reverse(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }
}
