package algorithms.linkedlist

// 1669. Merge In Between Linked Lists

fun mergeInBetween(head1: ListNode?, a: Int, b: Int, head2: ListNode?): ListNode? {
    val tail2 = getLastElementLinkedList(head2)
    var current = head1
    var count = 1
    while (count < a) {
        current = current?.next
        count++
    }
    var next = current?.next
    current?.next = head2
    while (count < b) {
        println(next?.`val`)
        next = next?.next
        count++
    }
    tail2?.next = next?.next
    return head1
}
