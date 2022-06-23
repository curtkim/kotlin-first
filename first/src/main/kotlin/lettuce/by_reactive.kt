package lettuce

import kotlinx.coroutines.*
import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import io.lettuce.core.TransactionResult
import io.lettuce.core.api.reactive.RedisReactiveCommands
import kotlinx.coroutines.reactive.awaitFirst


fun main(args : Array<String>) {
    val uri = RedisURI.create("localhost", 6379)
    val client = RedisClient.create(uri)

    val conn = client.connect()
    val api: RedisReactiveCommands<String, String> = conn.reactive()

    runBlocking {
        launch {
            println(set(api))
            println(get(api))
            println(getKeys(api))
            val result = doMulti(api)
            println(result.get<List<String>>(1))
        }
    }
    conn.close()
}

suspend fun set(api: RedisReactiveCommands<String, String>): String {
    return api.set("foo", "bar").awaitFirst()
}

suspend fun get(api: RedisReactiveCommands<String, String>): String {
    return api.get("foo").awaitFirst()
}

fun getKeys(api: RedisReactiveCommands<String, String>): List<String> {
    return api.keys("fo*").collectList().block()
}

suspend fun doMulti(api: RedisReactiveCommands<String, String>): TransactionResult {
    return api.multi().doOnSuccess {
        api.set("foo", "bar").subscribe()
        api.keys("fo*").subscribe()
    }.flatMap {
        api.exec()
    }.awaitFirst()
}