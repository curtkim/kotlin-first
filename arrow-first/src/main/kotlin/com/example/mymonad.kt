//https://lambda.show/blog/introduction-to-monads
package com.example

sealed class SuccessOrFailure

class Success<T>(val value: T) : SuccessOrFailure()
class Failure() : SuccessOrFailure()


fun <T> eitherMonad(function: () -> T): SuccessOrFailure {
    return try {
        return Success<T>(function())
    } catch (e: Throwable) {
        return Failure()
    }
}

fun main(args: Array<String>) {
    val result = eitherMonad({ java.io.File("name.txt").readText() })
    when (result) {
        is Success<*> -> println("Hello, ${result.value}")
        is Failure -> println("Couldn't find the file!")
    }
}