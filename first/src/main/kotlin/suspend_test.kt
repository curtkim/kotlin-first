import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


suspend fun getValue1(key: String): String {
    return "sync $key"
}

suspend fun getValue2(key: String): String {
    delay(1)
    return "async $key"
}

fun main(args: Array<String>) = runBlocking {
        println(getValue1("myid"))
        println(getValue2("myid"))
    }
