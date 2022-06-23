import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponse
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        val (req, res, result) = Fuel.get("http://httpbin.org/get").awaitStringResponse()
        println(result)
    }
}