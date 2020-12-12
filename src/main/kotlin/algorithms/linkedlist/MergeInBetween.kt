package algorithms.linkedlist

// leetcode

fun getLast(root: ListNode?): ListNode? {
    var current = root
    while (current?.next != null) {
        current = current.next
    }
    return current
}

fun mergeInBetween(head1: ListNode?, a: Int, b: Int, head2: ListNode?): ListNode? {
    val root2 = head2
    val tail2 = getLast(head2)
    val resultHead = head1
    var current = head1
    var count = 1
    while (count < a) {
        current = current?.next
        count++
    }
    var next = current?.next
    current?.next = root2
    while (count < b) {
        println(next?.`val`)
        next = next?.next
        count++
    }
    tail2?.next = next?.next
    return resultHead
}
