import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong

fun main(args: Array<String>) {

    suspend fun workload(n: Int): Int {
        delay(1000)
        return n
    }

    GlobalScope.async {
        workload(5)
    }
}
