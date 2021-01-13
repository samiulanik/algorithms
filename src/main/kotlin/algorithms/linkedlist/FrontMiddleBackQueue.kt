package algorithms.linkedlist

import java.util.LinkedList

// 1670. Design Front Middle Back Queue

class FrontMiddleBackQueue {
    private val list = LinkedList<Int>()

    fun pushFront(`val`: Int) {
        list.addFirst(`val`)
    }

    fun pushMiddle(`val`: Int) {
        list.add(list.size / 2, `val`)
    }

    fun pushBack(`val`: Int) {
        list.addLast(`val`)
    }

    fun popFront(): Int {
        if (list.isEmpty()) return - 1
        return list.removeFirst()
    }

    fun popMiddle(): Int {
        if (list.isEmpty()) return - 1
        return list.removeAt((list.size - 1) / 2)
    }

    fun popBack(): Int {
        if (list.isEmpty()) return - 1
        return list.removeLast()
    }
}
