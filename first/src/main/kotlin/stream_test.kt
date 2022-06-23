fun main(args : Array<String>) {
    val numbers = listOf(1, 2, 3)
    val strings = listOf("one", "two", "three")

    numbers.zip(strings)
        .map {(a, b)-> b+a}
        .forEach { println(it) }
}
