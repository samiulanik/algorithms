package algorithms.linkedlist

fun evenReverse(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var current = head
    var oddCurrent = head
    val evenHeadRoot = head.next
    var position = 1
    while (current?.next != null) {
        val next = current.next
        current.next = current.next!!.next
        current = next
        position++
    }
    var evenReverse = evenHeadRoot
    var prev: ListNode? = null
    while (evenReverse != null) {
        val next = evenReverse.next
        evenReverse.next = prev
        prev = evenReverse
        evenReverse = next
    }
    var reverseEvenCurrent = prev
    while (oddCurrent != null && reverseEvenCurrent != null) {
        val oddNext = oddCurrent.next
        val evenNext = reverseEvenCurrent.next
        oddCurrent.next = reverseEvenCurrent
        reverseEvenCurrent.next = oddNext
        oddCurrent = oddNext
        reverseEvenCurrent = evenNext
    }
    return head
}
