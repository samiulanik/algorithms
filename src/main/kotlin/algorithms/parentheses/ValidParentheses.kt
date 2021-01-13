package algorithms.parentheses

import java.util.Stack

// 20. Valid Parentheses

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val map = mutableMapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )
        val stack = Stack<Char>()
        s.forEach {
            if (map.containsKey(it)) stack.push(it)
            else {
                if (stack.empty() || map[stack.pop()] != it) return false
            }
        }
        return stack.isEmpty()
    }
}
