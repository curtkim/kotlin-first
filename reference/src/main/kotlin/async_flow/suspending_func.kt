package async_flow

import kotlinx.coroutines.*

suspend fun baz(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking<Unit> {
    baz().forEach { value -> println(value) }
}