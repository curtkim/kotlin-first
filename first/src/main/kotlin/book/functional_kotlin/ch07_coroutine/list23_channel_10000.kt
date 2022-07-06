package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>) = runBlocking {

    val channel = Channel<Char>()

    val jobs = List(1_000_000){
        launch {
            delay(1000)
            channel.send('.')
        }
    }

    repeat(1_000_000){
        print(channel.receive())
    }

    jobs.forEach { job-> job.join() }
}
