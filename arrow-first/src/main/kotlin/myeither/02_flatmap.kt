package myeither
import arrow.core.Either
import arrow.core.flatMap


fun main() {
    val right: Either<String, Int> = Either.Right(5)
    val value = right.flatMap{ Either.Right(it + 1) }
    println("value = $value")

    val value2 = right.map { it+1 }
    println("value2 = $value2")
}