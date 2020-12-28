package algorithms.sort

fun reorderLogFiles(logs: Array<String>): Array<String> {
    val pattern = Regex("(\\s)\\d")
    val letLogs = logs.filter { !it.contains(pattern) }
    val digitLogs = logs.filter { it.contains(pattern) }
    val finaLetLogs = letLogs.sortedWith(
        compareBy(
            { it.split(" ".toRegex(), limit = 2)[1] },
            { it.split(" ".toRegex(), limit = 2)[0] }
        )
    )

    return (finaLetLogs + digitLogs).toTypedArray()
}
