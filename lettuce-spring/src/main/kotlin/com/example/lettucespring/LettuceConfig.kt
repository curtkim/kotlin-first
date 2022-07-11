package com.example.lettucespring

import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.support.AsyncConnectionPoolSupport
import io.lettuce.core.support.AsyncPool
import io.lettuce.core.support.BoundedAsyncPool
import io.lettuce.core.support.BoundedPoolConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LettuceConfig {

    val host = "localhost"
    val port = 6379

    @Bean
    fun redisUri(): RedisURI {
        return RedisURI.create(host, port)
    }

    @Bean
    fun redisClient(uri: RedisURI): RedisClient {
        return RedisClient.create(uri)
    }

    @Bean
    fun redisPool(client: RedisClient, uri: RedisURI): AsyncPool<StatefulRedisConnection<String, Any>> {
        return AsyncConnectionPoolSupport.createBoundedObjectPool(
            { client.connectAsync(SerializedObjectCodec(), uri)},
            BoundedPoolConfig.create()
        )
    }

}