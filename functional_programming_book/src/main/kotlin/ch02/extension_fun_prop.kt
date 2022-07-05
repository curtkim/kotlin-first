package ch02

fun Int.show(): String = "value = $this"

val Int.show: String
    get() = "this.value = $this"

fun main(args: Array<String>) {
    println(1.show())
    println(1.show)
}
