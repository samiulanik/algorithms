package algorithms.string

// 1347. Minimum Number of Steps to Make Two Strings Anagram

import kotlin.math.abs

fun minSteps(s: String, t: String): Int {
    val count = Array(26) { 0 }
    s.forEach {
        count[it - 'a']++
    }

    t.forEach {
        count[it - 'a'] --
    }

    var sum = 0
    count.forEach { sum += abs(it) }

    return sum / 2
}

fun main() {
    println(minSteps("friend", "family"))
}
