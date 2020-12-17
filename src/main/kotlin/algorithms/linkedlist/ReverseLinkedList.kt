package algorithms.linkedlist

fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var prev: ListNode? = null
    var next: ListNode?
    var current = head
    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}
