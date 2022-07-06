package book.functional_kotlin.ch12_arrow

import arrow.core.curried
//import arrow.syntax.function.invoke

fun main(args: Array<String>) {
    val strong: (String, String, String) -> String = { body, id, style ->
        "<strong id=\"$id\" style=\"$style\">$body</strong>" }

    // Curried
    println(strong.curried()("Batman Begins")("trilogy1")("color:black"))

    // Fake curried, just partial application
    //println(strong("The Dark Knight")("trilogy2")("color:black"))

    // partial application
    //println(strong(p2 = "trilogy3")(p2 = "color:black")("The Dark Knight rises"))
}