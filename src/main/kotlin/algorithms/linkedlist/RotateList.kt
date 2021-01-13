package algorithms.linkedlist

// 61. Rotate List

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    val len = getLenLinkedList(head)
    if (k == 0 || len <= 1 || k % len == 0) return head
    val cutPosition = len - k % len
    var current = head
    var prev: ListNode? = null
    var position = 0
    while (current != null && position < cutPosition) {
        prev = current
        current = current.next
        position++
    }
    prev?.next = null
    val newHead = current
    while (current?.next != null) current = current.next
    current?.next = head

    return newHead
}
