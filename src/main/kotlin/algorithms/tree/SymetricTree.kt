package algorithms.tree

import java.util.LinkedList
import java.util.Queue

fun isSymmetric(root: TreeNode?): Boolean {
    val q: Queue<TreeNode?> = LinkedList()
    q.offer(root)
    val finalList = mutableListOf<MutableList<Int?>>()
    while (q.isNotEmpty()) {
        val list = mutableListOf<Int?>()
        var size = q.size
        while (size > 0) {
            val current = q.poll()
            list.add(current?.`val`)
            if (current != null) {
                q.add(current.left)
                q.add(current.right)
            }
            size--
        }
        finalList.add(list)
    }

    for (i in 1 until finalList.size) {
        if (!isSymmetricList(finalList[i])) return false
    }

    return true
}

fun isSymmetricList(list: MutableList<Int?>): Boolean {
    if (list.size % 2 == 1) return false
    var j = list.size - 1
    var i = 0

    while (i < j) {
        if (list[i] != list[j])
            return false
        i++
        j--
    }

    return true
}

fun main() {
    println(isSymmetricList(mutableListOf(3, 4, 4, 3)))
}
