import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono

class FluxMonoTest {

    suspend fun getMono(str : String): String{
       return Mono.just(str).awaitSingle()
    }

    @Test
    fun simple(){

        runBlocking {
            val a =getMono("hello")
            val b = getMono("world")
            println("$a $b")
        }

    }
}