package delegate

import java.text.SimpleDateFormat
import java.util.*

data class Book (val delegate : Map<String,Any?>) {
    val name:String by delegate
    val authors:String by delegate
    val pageCount:Int by delegate
    val publicationDate: Date by delegate
    val publisher:String by delegate
}

fun main(args: Array<String>) {
    val map1 = mapOf(
        Pair("name","Reactive Programming in Kotlin"),
        Pair("authors","Rivu Chakraborty"),
        Pair("pageCount",400),
        Pair("publicationDate", SimpleDateFormat("yyyy/mm/dd").parse("2017/12/05")),
        Pair("publisher","Packt")
    )

    val map2 = mapOf(
        "name" to "Kotlin Blueprints",
        "authors" to "Ashish Belagali, Hardik Trivedi, Akshay Chordiya",
        "pageCount" to 250,
        "publicationDate" to SimpleDateFormat("yyyy/mm/dd").parse("2017/12/05"),
        "publisher" to "Packt"
    )
    val book1 = Book(map1)
    val book2 = Book(map2)
    println("Book1 $book1 nBook2 $book2")
}