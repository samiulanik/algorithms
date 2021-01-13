package algorithms.linkedlist

// 25. Reverse Nodes in k-Group

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
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
            val revRoot = reverseLinkedList(currentRoot)
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
    if ((position - 1) % k != 0) {
        var currentTemp = finalHead
        while (currentTemp?.next != null) currentTemp = currentTemp.next
        currentTemp?.next = currentRoot
    }
    return finalHead
}
