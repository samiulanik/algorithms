package algorithms.string

import java.util.ArrayList

fun findAndReplacePattern(words: Array<String>, pattern: String): List<String>? {
    val p = normalization(pattern)
    val res: MutableList<String> = ArrayList()
    for (w in words) if (normalization(w).contentEquals(p)) res.add(w)
    return res
}

fun normalization(w: String): IntArray {
    val m = mutableMapOf<Char, Int>()
    val n = w.length
    val res = IntArray(n)
    for (i in w.indices) {
        m.putIfAbsent(w[i], m.size)
        res[i] = m[w[i]]!!
    }
    return res
}
