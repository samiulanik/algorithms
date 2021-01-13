package algorithms.linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun getLenLinkedList(node: ListNode?): Int {
    var current = node
    var len = 0
    while (current != null) {
        current = current.next
        len++
    }
    return len
}

fun reverseLinkedList(head: ListNode?): ListNode? {
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

fun getLastElementLinkedList(root: ListNode?): ListNode? {
    var current = root
    while (current?.next != null) {
        current = current.next
    }
    return current
}
