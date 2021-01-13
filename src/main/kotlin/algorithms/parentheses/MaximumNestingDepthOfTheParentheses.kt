package algorithms.parentheses

// 1614. Maximum Nesting Depth of the Parentheses

import java.util.Stack

fun maxDepth(s: String): Int {
    val stack = Stack<Char>()
    var max = 0
    var count = 0
    s.forEach {
        if (it == '(') {
            count++
            max = kotlin.math.max(count, max)
            stack.push(it)
        }
        if (it == ')') {
            stack.pop()
            count--
        }
    }

    return max
}
