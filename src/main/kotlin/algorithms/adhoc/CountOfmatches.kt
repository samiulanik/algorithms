package algorithms.adhoc

// 1688. Count of Matches in Tournament

fun numberOfMatches(n: Int): Int {
    var teamCount = n
    var matchCount = 0
    while (teamCount > 1) {
        val mod = teamCount % 2
        teamCount /= 2
        matchCount += teamCount
        teamCount += mod
    }
    return matchCount
}
