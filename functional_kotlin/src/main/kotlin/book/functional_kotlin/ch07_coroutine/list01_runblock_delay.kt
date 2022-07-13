package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    var job = launch {
        delay(1000)
        println("world")
    }
    println("hello")
    job.join()
}

