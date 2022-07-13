package book.functional_kotlin.ch07_coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>) = runBlocking {

    val channel = Channel<Char>()

    val sender =launch {
        repeat(1000){
            delay(10)
            channel.send('.')
            delay(10)
            channel.send(',')
        }
    }

    for(msg in channel)
        print(msg)

    sender.join()
}
