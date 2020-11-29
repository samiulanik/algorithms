package basics

fun main() {
    val list = listOf(
        Employee(1, "john doe", 25, 100000.00),
        Employee(2, "john raul", 25, 90000.00),
        Employee(3, "john smith", 26, 200000.00)
    )
    val array = arrayOf(
        Employee(1, "john doe", 25, 100000.00),
        Employee(2, "john raul", 25, 90000.00),
        Employee(3, "john smith", 26, 200000.00)
    )
    println(list.associateBy({ it.id }, { it }))
    println(array.associateBy({ it.id }, { it }))
}
