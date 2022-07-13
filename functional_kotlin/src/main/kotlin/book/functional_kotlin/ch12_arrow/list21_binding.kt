package book.functional_kotlin.ch12_arrow

import arrow.core.partially1

fun main(args: Array<String>) {
    val footer: (String)->String = {content -> "<footer>$content</footer>"}

    //val fixFooter: ()-> String = footer.bind("Functional Kotlin - 2018")
    //println(fixFooter())

    val fixFooter2: ()-> String = footer.partially1("Functional Kotlin - 2018")
    println(fixFooter2())
}
