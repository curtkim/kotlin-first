package lettuce

import kotlinx.coroutines.*
import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import io.lettuce.core.TransactionResult
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import io.lettuce.core.api.coroutines.RedisCoroutinesCommands
import kotlinx.coroutines.flow.first

//
fun main(args : Array<String>) {
    val uri = RedisURI.create("localhost", 6379)
    val client = RedisClient.create(uri)

    val conn = client.connect()
    val api: RedisCoroutinesCommands<String, String> = conn.coroutines()

    runBlocking {
        launch {
            println(doit3(api))
        }
    }
    conn.close()
}

suspend fun doit(api: RedisCoroutinesCommands<String, String>): String {

    val foo1 = api.set("foo", "bar")
    val foo2 = api.keys("fo*")
    return foo2.first();
}

suspend fun doit3(api: RedisCoroutinesCommands<String, String>): TransactionResult {
    println("doit3")
    val a = api.multi()
    println("multi "+a)
    val foo1 = api.set("foo", "bar") // 여기서 멈춤 ㅠㅠ
    println("set")
    val foo2 = api.keys("fo*")
    println("keys")
    return api.exec()
}

/*
suspend fun doit2(api: RedisCoroutinesCommands<String, String>): String {

    val one = async(Dispatchers.Default) { api.set("foo", "bar")}
    val two = async(Dispatchers.Default) { api.keys("fo*")}
}

 */