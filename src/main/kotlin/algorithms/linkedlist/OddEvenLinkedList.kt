package algorithms.linkedlist

fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var current = head
    var next: ListNode?
    val evenHead = current.next
    var prev: ListNode? = null
    var count = 1
    while (current?.next != null) {
        prev = current
        next = current.next
        current.next = current.next!!.next
        current = next
        count++
    }

    when {
        count % 2 == 0 -> prev?.next = evenHead
        else -> current?.next = evenHead
    }

    return head
}
