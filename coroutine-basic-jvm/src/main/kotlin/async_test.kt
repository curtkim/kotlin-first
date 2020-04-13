import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong

fun main(args: Array<String>) {

    val deferred = (1..1_000_000).map { n ->
        GlobalScope.async {
            delay(1000)
            n
        }
    }

    runBlocking {
        val sum = deferred.map { it.await().toLong() }.sum()
        println("Sum: $sum")
    }
}