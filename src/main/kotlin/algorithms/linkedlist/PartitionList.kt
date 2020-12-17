package algorithms.linkedlist

fun partition(head: ListNode?, x: Int): ListNode? {
    if (head?.next == null) return head
    var newHead = head
    var current = head
    var anotherHead = head
    while (newHead != null && newHead.`val` >= x) newHead = newHead.next
    val smallHead = newHead
    while (anotherHead != null && anotherHead.`val` < x) anotherHead = anotherHead.next
    val bigHead = anotherHead

    if (smallHead == null || bigHead == null) return head

    while (current != null) {
        val next = current.next

        when {
            current.`val` >= x -> {
                anotherHead?.next = current
                anotherHead = anotherHead?.next
            }
            else -> {
                newHead?.next = current
                newHead = newHead?.next
            }
        }
        current = next
    }
    newHead?.next = bigHead
    anotherHead?.next = null

    return smallHead
}
