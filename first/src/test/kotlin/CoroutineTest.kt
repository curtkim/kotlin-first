//https://www.baeldung.com/kotlin/coroutines
import kotlinx.coroutines.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CoroutineTest {

    @Test
    fun `sequence and yield`(){
        val fibonacciSeq = sequence {
            var a = 0
            var b = 1

            yield(1)

            while (true) {
                yield(a + b)

                val tmp = a + b
                a = b
                b = tmp
            }
        }

        val res = fibonacciSeq
            .take(5)
            .toList()

        assertEquals(res, listOf(1, 1, 2, 3, 5))
    }

    suspend fun expensiveComputation(res: MutableList<String>) {
        println(Thread.currentThread().name)    // main @coroutine#2
        delay(1000L)
        res.add("word!")
    }

    @Test
    fun givenAsyncCoroutine_whenStartIt_thenShouldExecuteItInTheAsyncWay() {
        println(Thread.currentThread().name) // main
        //given
        val res = mutableListOf<String>()

        //when
        runBlocking {
            launch { expensiveComputation(res) }
            res.add("Hello,")
        }

        //then
        assertEquals(res, listOf("Hello,", "word!"))
    }

    @Test
    fun givenCancellableJob_whenRequestForCancel_thenShouldQuit() {
        runBlocking<Unit> {
            //given
            val job = launch(Dispatchers.Default) {
                while (isActive) {
                    //println("is working")
                }
            }

            delay(1300L)

            //when
            job.cancel()

            //then cancel successfully
        }
    }

    suspend fun someExpensiveComputation(time : Long): Long {
        delay(time)
        return time
    }

    @Test
    fun `async await`() {
        runBlocking<Unit> {
            val delay = 1000L
            val time = measureTimeMillis {
                //given
                val one = async(Dispatchers.Default) { someExpensiveComputation(delay) }
                val two = async(Dispatchers.Default) { someExpensiveComputation(delay) }

                //when
                runBlocking {
                    one.await()
                    two.await()
                }
            }

            //then
            assertTrue(time < delay * 2)
        }
    }

    @Test
    fun givenTwoExpensiveAction_whenExecuteThemLazy_thenTheyShouldNotConcurrently() {
        runBlocking<Unit> {
            val delay = 1000L
            val time = measureTimeMillis {
                //given
                val one = async(Dispatchers.Default, CoroutineStart.LAZY) { someExpensiveComputation(delay) }
                val two = async(Dispatchers.Default, CoroutineStart.LAZY) { someExpensiveComputation(delay) }

                //when
                runBlocking {
                    one.await()
                    two.await()
                }
            }

            //then
            assertTrue(time > delay * 2)
        }
    }
}