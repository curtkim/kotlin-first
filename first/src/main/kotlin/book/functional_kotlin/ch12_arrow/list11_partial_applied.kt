package book.functional_kotlin.ch12_arrow

import arrow.core.partially3


fun main(args: Array<String>) {

    val strong: (String, String, String) -> String = { body, id, style ->
        "<strong id=\"$id\" style=\"$style\">$body</strong>" }

    val redStrong: (String, String) -> String = strong.partially3("font: red")  //Explicit
    //val blueStrong: (String, String) -> String = strong(p3 = "font: blue")          //Implicit

    println(redStrong("Red Sonja", "movie1"))
    //println(blueStrong("Deep blue Sea", "movie2"))
}
