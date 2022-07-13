package myeither
import arrow.core.Either
import arrow.core.flatMap

fun main() {
    val left: Either<String, Int> = Either.Left("Something went wrong")
    val value = left.flatMap{ Either.Right(it + 1) }
    println("value = $value")
}