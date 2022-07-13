package book.functional_kotlin.ch12_arrow

import arrow.core.andThen
import arrow.core.compose
import java.util.*

val p: (String) -> String = { body -> "<p>$body</p>" }
val span: (String) -> String = { body -> "<span>$body</span>" }
val div: (String) -> String = { body -> "<div>$body</div>" }
val strong: (String) -> String = { body -> "<strong>$body</strong>" }

val randomNames: () -> String = {
    if (Random().nextInt() % 2 == 0) {
        "foo"
    } else {
        "bar"
    }
}

fun main(args: Array<String>) {
    val divString: (String)->String = div compose strong
    val spanP: (String)->String = p andThen span
    val randomStrong: ()->String = randomNames andThen strong

    println(divString("Hello composition world!"))
    println(spanP("Hello compsition world!"))
    println(randomStrong())
}
