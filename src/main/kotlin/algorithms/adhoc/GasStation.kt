package algorithms.adhoc

// 134. Gas Station

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    if (gas.sum() < cost.sum()) return -1
    var sum = 0
    var start = 0
    for (i in gas.indices) {
        sum += gas[i] - cost[i]
        if (sum < 0) {
            start = i + 1
            sum = 0
        }
    }
    return start
}
