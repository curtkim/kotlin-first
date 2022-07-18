fun <T> listOfElementAndLength(element: T, length: Int): List<T> {
    return buildList<T> {
        List(length) {
            add(element)
        }
    }
}

fun main(args: Array<String>) {
    println(listOf(1, 2))
    val filteredList = listOfNotNull("A", "B", null)
    println(filteredList)

    val students = listOf("Hertz", "Jane")
    val myList = buildList(students.size + 1) {
        add("Jitendra")
        addAll(students)
    }
    println(myList)

    println(listOfElementAndLength("A", 3))

    listOf(1, 2, 3)
        .flatMap { listOfElementAndLength(it, it) }
        .flatMap { listOf(it*2) }
        .forEach{print(it)}

}