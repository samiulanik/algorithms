package algorithms.parentheses

import java.util.Stack

// 921. Minimum Add to Make Parentheses Valid

fun minAddToMakeValid(s: String): Int {
    val stack = Stack<Char>()
    var count = 0
    for (i in s.indices) {
        if (s[i] == '(') stack.push(s[i])
        else {
            if (stack.isNotEmpty()) stack.pop()
            else count++
        }
    }

    return stack.size + count
}
