package algorithms.linkedlist

// leetcode

fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
    var current = root
    val len = getLenLinkedList(root)
    var mod = len % k
    var partSize = len / k
    var result: Array<ListNode?> = arrayOfNulls(k)
    var index = 0

    while (current != null) {
        result[index++] = current
        (1 until partSize).forEach { _ -> current = current!!.next }
        if (mod > 0 && partSize > 0) {
            current = current!!.next
            mod--
        }
        val temp = current!!.next
        current!!.next = null
        current = temp
    }
    return result
}
