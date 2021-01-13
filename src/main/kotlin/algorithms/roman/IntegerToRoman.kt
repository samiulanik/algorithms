package algorithms.adhoc

import java.lang.StringBuilder

fun intToRoman(num: Int): String {
    val map = linkedMapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var n = num
    val sb = StringBuilder()
    map.forEach { (t, u) ->
        while (n - t >= 0) {
            n -= t
            sb.append(u)
        }
    }
    return sb.toString()
}

fun main() {
    println(intToRoman(10))
}
