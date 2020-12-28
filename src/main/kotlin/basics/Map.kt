package basics

fun main() {
    val list = listOf(
        Student(1, "john doe", 25, 3.3),
        Student(2, "john raul", 25, 3.4),
        Student(3, "john smith", 26, 2.9)
    )
    val array = arrayOf(
        Student(1, "john doe", 25, 3.3),
        Student(2, "john raul", 25, 3.4),
        Student(3, "john smith", 26, 2.88)
    )
    println(list.associateBy({ it.id }, { it }))
    println(array.associateBy({ it.id }, { it }))
}
