// https://www.baeldung.com/kotlin/flow-intro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Month
import kotlin.test.assertEquals

class FlowTest {

    @Test
    fun emit() = runTest {
        val flowWithSingleValue = flow { emit(0) }
        assertEquals(listOf(0), flowWithSingleValue.toList())
    }

    @Test
    fun asFlow() = runTest {
        val inscription = buildString {
            listOf("mene", "mene", "tekel", "upharsin")
                .asFlow()
                .collect { append(it).append(", ") }
        }.removeSuffix(", ")
        assertEquals(inscription, "mene, mene, tekel, upharsin")
    }

    @Test
    fun test3() = runTest {
        val data = flow { "PEACE".asSequence().forEach { emit(it.toString()) } }
        val charList = data.toList()
        assertEquals(5, charList.size)

        val symbols = data.toSet()
        assertEquals(4, symbols.size)

        val word = data.reduce { acc, c -> acc + c }
        assertEquals("PEACE", word)

        val firstLetter = data.first()
        assertEquals("P", firstLetter)
    }

    @Test
    fun transform() = runTest {
        val monthsOfSorrow = Month.values().asFlow()
            .transform {
                if (it <= Month.FEBRUARY)
                    emit(it)
            }
            .toList()
        assertEquals(listOf(Month.JANUARY, Month.FEBRUARY), monthsOfSorrow)
    }

    @Test
    fun `conflact (It skips values between two consecutive invocations of a collector function)`() = runTest {
        val buffer = mutableListOf<Int>()
        (1..10).asFlow()
            .transform {
                delay(10)
                emit(it)
            }
            .conflate()
            .collect {
                delay(50)
                buffer.add(it)
            }
        println(buffer) // maybe [1, 5, 10]
        assertTrue { buffer.size < 10 }
    }

    @Test
    fun compose() = runTest {
        val codes = listOf(80, 69, 65, 67).asFlow()
        val symbols = listOf('P', 'A', 'C', 'E').asFlow()
        val list = buildList {
            codes.zip(symbols) { code, symbol -> add("$code -> $symbol") }.collect()
        }
        assertEquals(listOf("80 -> P", "69 -> A", "65 -> C", "67 -> E"), list)
    }

    @Test
    fun handleException() = runTest {
        val result = (1..10).asFlow()
            .transform {
                if (it > 3) throw IllegalArgumentException("Too much")
                emit(it)
            }
            .catch {
                when (it) {
                    is IllegalArgumentException -> emit(3)
                    else -> throw it // rethrow unknown exceptions
                }
            }
            .toList()
        assertEquals(listOf(1, 2, 3, 3), result)
    }

    @Test
    fun backpressure() = runTest {
        val fastFlow = flow {
            (1..10).forEach {
                println("Before waiting: $it")
                delay(10)
                println("About to emit: $it")
                emit(it)
                println("After emitting: $it")
            }
        }

        fastFlow.collect {
            Thread.sleep(100) // Imitate hard CPU-bound operation
            println("Collected $it")
        }
    }

    @Test
    fun flowContext() = runTest {
        flow {
            (1..10).forEach { emit(it) }
            assertTrue { "DefaultDispatcher-worker" in Thread.currentThread().name }
        }.flowOn(Dispatchers.IO)
            .collect {
                println(it)
                assertTrue { "main" in Thread.currentThread().name }
            }
    }
}