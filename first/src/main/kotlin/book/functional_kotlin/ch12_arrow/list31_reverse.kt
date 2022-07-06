package book.functional_kotlin.ch12_arrow

import arrow.core.partially3

fun main(args: Array<String>) {
    val strong: (String, String, String)-> String = {body, id, style ->
        "<strong id=\"$id\" style=\"$style\">$body</strong>"
    }

    val redStrong: (String, String)-> String = strong.partially3("font:red")
    println(redStrong("red sonja", "movie1"))
    //println(redStrong.reverse()("movie2", "The Hunt"))
}
