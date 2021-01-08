package algorithms.adhoc

// 13. Roman to Integer

fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    val len = s.length
    val first = if (map[s[0]] == null) 0 else map[s[0]]
    if (len == 0) return 0 else if (len == 1) return map[s[0]]!!
    var count = first!!
    for (i in 1 until len) {
        val value = map[s[i]]!!
        val preValue = map[s[i - 1]]!!
        count += value
        if (value > preValue) {
            count -= preValue * 2
        }
    }
    return count
}
