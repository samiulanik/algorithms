package algorithms.string

fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
    var diff = 0
    var res = 'a'
    keysPressed.forEachIndexed { index, ch ->
        val duration = if (index == 0) releaseTimes[index] else releaseTimes[index] - releaseTimes[index - 1]
        if (duration > diff) {
            diff = duration
            res = ch
        } else if (diff == duration && res < ch) res = ch
    }

    return res
}
