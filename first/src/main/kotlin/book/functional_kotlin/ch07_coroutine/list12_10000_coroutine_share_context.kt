package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    val job = launch {
        List(10000) {
            // share context of parent
            launch(coroutineContext) {
                delay(1000)
                println(".")
            }
        }
    }
    job.join()
}

