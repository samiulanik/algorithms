package algorithms.linkedlist

// leetcode

fun swapPairs(head: ListNode?): ListNode? {
    var current = head
    val newHead = head?.next
    if (head?.next == null) {
        return head
    }
    var prev: ListNode? = null
    while (current?.next != null) {
        val next = current.next
        current.next = next?.next
        next?.next = current
        if (prev != null) prev.next = next
        prev = current
        current = current.next
    }

    return newHead
}
