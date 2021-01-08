package algorithms.clone

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun copyRandomList(head: Node?): Node? {
    if (head == null) return null
    val map = mutableMapOf<Node, Node>()
    val copyHead = Node(head.`val`)
    map[head] = copyHead
    var current = head
    var currentCopy: Node? = copyHead
    current = current.next

    while (current != null) {
        val node = Node(current.`val`)
        map[current] = node
        currentCopy?.next = node
        currentCopy = currentCopy?.next!!
        current = current.next
    }

    current = head
    currentCopy = copyHead

    while (current != null) {
        if (current.random != null) {
            currentCopy?.random = map[current.random!!]
        }
        current = current.next
        currentCopy = currentCopy?.next
    }

    return copyHead
}
