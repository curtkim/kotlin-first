package com.example.lettucespring

import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.support.AsyncPool
import kotlinx.coroutines.future.await
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class LettuceListTest(@Autowired val redisPool: AsyncPool<StatefulRedisConnection<String, Any>>) {

    @Test
    fun `serializable codec`() = runTest {
        redisPool.acquire().await().use { conn ->
            val commands = conn.reactive()
            val emp1 = Employee("bob", 20)
            commands.set("emp1", emp1).awaitSingle()
            val emp2 = commands.get("emp1").cast(Employee::class.java).awaitSingle()
            assertEquals(emp1, emp2)
        }
    }

    @Test
    fun `rpush multi`() = runTest {
        redisPool.acquire().await().use { conn ->
            val commands = conn.reactive()
            commands.flushdb().awaitSingle()

            val emp1 = Employee("bob", 20)
            val emp2 = Employee("alice", 20)
            val updateCount = commands.rpush("list", emp1, emp2).awaitSingle()
            assertEquals(2, updateCount)

            val list = commands.lrange("list", 0, 1).cast(Employee::class.java).collectList().awaitSingle()
            assertEquals(emp1, list[0])
            assertEquals(emp2, list[1])
        }
    }

    @Test
    fun `rpush multi by *`() = runTest {
        redisPool.acquire().await().use { conn ->
            val commands = conn.reactive()
            commands.flushdb().awaitSingle()

            val emp1 = Employee("bob", 20)
            val emp2 = Employee("alice", 20)
            val list = listOf(emp1, emp2)
            val updateCount = commands.rpush("list", *list.toTypedArray()).awaitSingle()
            assertEquals(2, updateCount)
        }
    }
}