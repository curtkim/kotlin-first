package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    println("run blocking coroutineContext = $coroutineContext")
    println("coroutineContext[Job] = ${coroutineContext[Job]}")
    println(Thread.currentThread().name)
    println("-----")

    val jobs = listOf(
        launch {
            println("1. launch coroutineContext = $coroutineContext")
            println("1. coroutineContext[Job] = ${coroutineContext[Job]}")
            println(Thread.currentThread().name)
            println("1. -----")
        },
        async {
            println("2. async coroutineContext = $coroutineContext")
            println("2. coroutineContext[Job] = ${coroutineContext[Job]}")
            println(Thread.currentThread().name)
            println("2. -----")
        },
//        launch(CommonPool) {
//            println("common launch coroutineContext = $coroutineContext")
//            println("coroutineContext[Job] = ${coroutineContext[Job]}")
//            println(Thread.currentThread().name)
//            println("-----")
//        },
        launch(coroutineContext) {
            println("4. inherit launch coroutineContext = $coroutineContext")
            println("4. coroutineContext[Job] = ${coroutineContext[Job]}")
            println(Thread.currentThread().name)
            println("4. -----")
        }
    )

    println("jobs.size="+jobs.size)
    jobs.forEach { job ->
        println("\tjob = $job")
        job.join()
    }
}
