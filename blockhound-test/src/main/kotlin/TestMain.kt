import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.debug.CoroutinesBlockHoundIntegration
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import reactor.blockhound.BlockHound

/**
 * A suspend function with an awful blocking sleep!
 */

suspend fun httpCall() {
    Thread.sleep(200)
    delay(5000)
}

fun main(): Unit = runBlocking(Dispatchers.Default) {
    BlockHound.install(CoroutinesBlockHoundIntegration())
    httpCall()
}