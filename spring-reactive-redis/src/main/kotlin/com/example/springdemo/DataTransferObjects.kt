package com.example.springdemo

import java.time.ZoneId
import java.time.ZonedDateTime

enum class CounterAction {UP, DOWN}

class CounterEvent(
    val value: Long,
    val action: CounterAction,
    val at: ZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"))
)

class CounterState(
    val value: Long,
    val at: ZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"))
){
    fun toEvent(action: CounterAction) = CounterEvent(value, action, at)
}