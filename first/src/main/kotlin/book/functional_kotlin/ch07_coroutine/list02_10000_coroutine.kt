package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    val jobs = List(10000) {
       launch {
           delay(1000)
           println(".")
       }
    }

    jobs.forEach { it.join() }
}

