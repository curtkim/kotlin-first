package book.functional_kotlin.ch12_arrow

//import arrow.syntax.function.curried
//import arrow.syntax.function.reverse
//import arrow.syntax.function.pipe

fun main(args: Array<String>) {
    val strong: (String, String, String) -> String = { body, id, style ->
        "<strong id=\"$id\" style=\"$style\">$body</strong>"
    }
    //val curriedStrong: (style: String) -> (id: String) -> (body: String) -> String = strong.reverse().curried()
    //val greenStrong: (id: String) -> (body: String) -> String = curriedStrong("color:green")

    //println(greenStrong("movie5")("Green Inferno"))
    //"Fried Green Tomatos" pipe ("movie7" pipe greenStrong) pipe ::println
}
