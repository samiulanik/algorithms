package algorithms.parentheses

import java.util.Stack

// 678. Valid Parenthesis String

fun checkValidString(s: String): Boolean {
    val pStack = Stack<Int>()
    val sStack = Stack<Int>()

    s.forEachIndexed { index, ch ->
        when (ch) {
            '(' -> pStack.push(index)
            '*' -> sStack.push(index)
            else -> {
                when {
                    pStack.isNotEmpty() -> pStack.pop()
                    sStack.isNotEmpty() -> sStack.pop()
                    else -> return false
                }
            }
        }
    }

    while (pStack.isNotEmpty()) {
        if (sStack.isEmpty() || sStack.peek() < pStack.peek()) return false
        pStack.pop()
        sStack.pop()
    }

    return true
}

fun main() {
    println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"))
}
