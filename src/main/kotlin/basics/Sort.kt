package basics

fun main() {
    val list = listOf(
        Student(1, "john doe", 25, 3.3),
        Student(2, "john raul", 25, 2.1),
        Student(3, "john smith", 26, 3.66)
    )

    println(list.sortedWith(compareBy({ it.age }, { it.cgpa })))
    println(list.sortedByDescending { it.age })
    println(list.sortedWith(compareByDescending<Student> { it.cgpa }.thenByDescending { it.age }))
}
