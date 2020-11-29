package basics

fun main() {
    val list = listOf(
        Employee(1, "john doe", 25, 100000.00),
        Employee(2, "john raul", 25, 90000.00),
        Employee(3, "john smith", 26, 200000.00)
    )

    println(list.sortedWith(compareBy({ it.age }, { it.salary })))
    println(list.sortedByDescending { it.age })
    println(list.sortedWith(compareByDescending<Employee> { it.salary }.thenByDescending { it.age }))
}
