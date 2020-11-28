package algorithms

// hacker rank
// connected component count

fun journeyToMoon(n: Int, astronaut: Array<Array<Int>>): Long {
    val visited = BooleanArray(n)
    val adjMap = mutableMapOf<Int, MutableList<Int>>()
    (0 until n).forEach {
        adjMap[it] = mutableListOf()
    }

    astronaut.forEach {
        adjMap[it[0]]?.add(it[1])
        adjMap[it[1]]?.add(it[0])
    }

    val resultList = mutableListOf<MutableList<Int>>()
    (0 until n).forEach {
        if (!visited[it]) {
            val connectedList = mutableListOf<Int>()
            dfsConnected(it, visited, adjMap, connectedList)
            resultList.add(connectedList)
        }
    }
    var sum: Long = 0
    var result: Long = 0
    resultList.forEach {
        result += sum * it.size
        sum += it.size
    }
    return result
}

fun dfsConnected(v: Int, visited: BooleanArray, adjMap: MutableMap<Int, MutableList<Int>>, connectedList: MutableList<Int>) {
    visited[v] = true
    connectedList.add(v)
    for (value in adjMap[v]!!) {
        if (!visited[value]) {
            dfsConnected(value, visited, adjMap, connectedList)
        }
    }
}

fun main() {
    println(
        journeyToMoon(
            100000,
            arrayOf(
                arrayOf(1, 2),
                arrayOf(3, 4)
            )
        )
    )
}
