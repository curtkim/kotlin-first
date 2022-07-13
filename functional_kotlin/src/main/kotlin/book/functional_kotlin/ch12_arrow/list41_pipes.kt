package book.functional_kotlin.ch12_arrow

//import arrow.syntax.function.pipe

fun main(args: Array<String>) {
    val strong: (String)->String = {body -> "<strong>$body</strong>"}
    //"From a pipe".pipe(strong).pipe(::println)
}