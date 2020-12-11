package algorithms.sort

// hacker rank TLE

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var counter = 0
    if (expenditure.size <= d) {
        return counter
    }

    for (i in expenditure.indices) {
        var slice = Array(d) { 0 }
        if (i + d - 1 < expenditure.size - 1) {
            slice = expenditure.sliceArray(i until i + d)
        }
        var maiden = if (d % 2 == 1) kSelection(slice, 0, d - 1, d / 2 + 1) else (
            kSelection(slice, 0, d - 1, d / 2) +
                kSelection(slice, 0, d - 1, d / 2 - 1)
            ) / 2

        println(maiden)
        if (i + d < expenditure.size && expenditure[i + d] >= maiden * 2) {
            counter++
        }
    }
    return counter
}

fun main() {
    println(
        activityNotifications(arrayOf(10, 20, 30, 40, 50), 3)
        // kSelection(arrayOf(10, 20, 30), 0, 2, 2)
    )
}
