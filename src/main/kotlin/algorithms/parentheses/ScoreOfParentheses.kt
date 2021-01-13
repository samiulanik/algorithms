package algorithms.parentheses

import java.util.Stack

// 856. Score of Parentheses

fun scoreOfParentheses(s: String): Int {
    var curr = 0
    val st = Stack<Int>()
    s.forEach {
        curr = if (it == '(') {
            st.push(curr)
            0
        } else {
            st.pop() + if (curr == 0) 1 else curr * 2
        }
    }
    return curr
}
