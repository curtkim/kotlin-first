package com.example.counterwithjava

import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import io.lettuce.core.api.coroutines.RedisCoroutinesCommands
import io.lettuce.core.support.AsyncPool
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.future.await
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.data.redis.core.*
import org.springframework.stereotype.Repository

@Repository
class CounterRepository(
    private val pool: AsyncPool<StatefulRedisConnection<String, String>>
) {
    suspend fun get(): CounterState {
        pool.acquire().await().use { conn->
            return CounterState(conn.reactive().incrby(COUNTER_KEY, 0).awaitSingle())
            //return CounterState(conn.coroutines().incrby(COUNTER_KEY, 0)!!)
        }
    }

    suspend fun up(): CounterState {
        pool.acquire().await().use { conn->
            return CounterState(conn.reactive().incr(COUNTER_KEY).awaitSingle())
            //return CounterState(conn.coroutines().incr(COUNTER_KEY) ?: 0)
        }
    }

    /*
    suspend fun down(): CounterState =
        CounterState(redisTemplate.opsForValue().decrementAndAwait(COUNTER_KEY)).also {
            redisTemplate.sendAndAwait(COUNTER_CHANNEL, it.toEvent(CounterAction.DOWN))
        }

    suspend fun stream(): Flow<CounterEvent> =
        redisTemplate.listenToChannelAsFlow(COUNTER_CHANNEL).map { it.message }
    */

    companion object {
        private const val COUNTER_CHANNEL = "COUNTER_CHANNEL"
        private const val COUNTER_KEY = "COUNTER"
    }
}