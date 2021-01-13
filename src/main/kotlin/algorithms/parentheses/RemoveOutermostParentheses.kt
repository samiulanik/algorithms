package algorithms.parentheses

import java.lang.StringBuilder

fun removeOuterParentheses(s: String): String {
    var n = 0
    val sb = StringBuilder()
    for (i in s.indices) {
        when (s[i]) {
            '(' -> {
                if (n > 0) sb.append(s[i])
                n++
            }
            else -> {
                n--
                if (n > 0) sb.append(s[i])
            }
        }
    }
    return sb.toString()
}
