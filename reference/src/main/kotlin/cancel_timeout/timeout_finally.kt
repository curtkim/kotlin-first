package cancel_timeout

import kotlinx.coroutines.*

fun main() = runBlocking {

    try {
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
    } finally {
        println("job: I'm running finally")
    }

    println("at end")
}