package book.functional_kotlin.ch12_arrow

//import arrow.syntax.function.reverse
//import arrow.syntax.function.pipe3
//import arrow.syntax.function.pipe

fun main(args: Array<String>) {
    val strong: (String, String, String) -> String = { body, id, style ->
        "<strong id=\"$id\" style=\"$style\">$body</strong>" }

    //val redStrong: (String, String)-> String = "color:red" pipe3 strong.reverse()
    //redStrong("movie3", "Three colors: Red") pipe ::println
}
