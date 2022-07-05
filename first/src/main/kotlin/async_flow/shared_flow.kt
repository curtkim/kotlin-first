package async_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import log
import kotlin.random.Random

fun randomSharedFlow(): Flow<Int> {
    val sharedFlow = MutableSharedFlow<Int>()

    GlobalScope.launch(Dispatchers.Default) {
        for (i in 0 until 10) {
            log("emit")
            sharedFlow.emit(Random.nextInt(1,100))
            delay(200)
        }
    }

    return sharedFlow
}

fun main() {
    val sharedFlow = randomSharedFlow()

    GlobalScope.launch(Dispatchers.IO) {
        sharedFlow.collect { log("Collector A: $it") }
        println("That's all folks!")
    }

    GlobalScope.launch(Dispatchers.IO) {
        sharedFlow.collect { log("Collector B: $it") }
        println("That's all folks!")
    }

    println("...and we're off!")
    Thread.sleep(3_000)
}