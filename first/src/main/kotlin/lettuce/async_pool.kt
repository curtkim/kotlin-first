package lettuce

import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import io.lettuce.core.api.coroutines.RedisCoroutinesCommands
import io.lettuce.core.codec.StringCodec
import io.lettuce.core.support.AsyncConnectionPoolSupport
import io.lettuce.core.support.BoundedAsyncPool
import io.lettuce.core.support.BoundedPoolConfig
import kotlinx.coroutines.future.await
import kotlinx.coroutines.runBlocking


fun main(args : Array<String>) {

    val client = RedisClient.create();

    val host = "localhost"
    val port = 6379
    val pool = AsyncConnectionPoolSupport.createBoundedObjectPool(
        { client.connectAsync(StringCodec.UTF8, RedisURI.create(host, port))},
        BoundedPoolConfig.create()
    )

    runBlocking {
        println(doit(pool))
    }

    pool.close()
}

suspend fun doit(asyncPool: BoundedAsyncPool<StatefulRedisConnection<String, String>>) : String {
    asyncPool.acquire().await().use {
        val api: RedisCoroutinesCommands<String, String> = it.coroutines()

        val foo1 = api.set("foo", "bar")
        val foo2 = api.get("foo")
        return foo2!!
    }
}