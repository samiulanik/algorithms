package algorithms.string

fun alphabetBoardPath(target: String?): String? {
    if (target == null) return ""
    val sb = StringBuilder()
    var previ = 0
    var prevj = 0
    for (i in target.indices) {
        val curi = (target[i] - 'a') / 5
        val curj = (target[i] - 'a') % 5
        if (curi == previ && curj == prevj) {
            sb.append("!")
        } else {
            printPath(sb, previ, prevj, curi, curj)
            sb.append("!")
            previ = curi
            prevj = curj
        }
    }
    return sb.toString()
}

fun printPath(sb: StringBuilder, previ: Int, prevj: Int, curi: Int, curj: Int) {
    var curi = curi
    var curj = curj
    while (curi < previ) {
        sb.append("U")
        curi++
    }
    while (curj > prevj) {
        sb.append("R")
        curj--
    }
    while (curj < prevj) {
        sb.append("L")
        curj++
    }
    while (curi > previ) {
        sb.append("D")
        curi--
    }
}

fun main() {
    println(alphabetBoardPath("leet"))
}
