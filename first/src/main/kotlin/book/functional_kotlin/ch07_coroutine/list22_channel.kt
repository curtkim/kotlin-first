package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>) = runBlocking {

    val channel = Channel<String>()

    val world = launch {
        delay(500)
        channel.send("World (from another coroutine)")
    }
    val hello = launch {
        println("Hello ${channel.receive()}")
    }

    hello.join()
    world.join()
}
