package com.example.restapi

import com.example.core.Adder
import kotlinx.coroutines.delay
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait


@Component
class Handler(val adder: Adder) {
    suspend fun add(request: ServerRequest): ServerResponse {
        delay(10)
        val a = request.queryParam("a").get().toInt()
        val b = request.queryParam("b").get().toInt()
        return ServerResponse.ok().bodyValueAndAwait(adder.add(a, b))
    }
}