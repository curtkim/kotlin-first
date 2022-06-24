package com.example.spring_functional_web

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class Handler {

    val products = listOf(
        Product("a", 1),
        Product("b", 2),
    )

    suspend fun findAll(request: ServerRequest): ServerResponse{
        delay(10)
        return ServerResponse.ok().bodyAndAwait(products.asFlow())
    }

    suspend fun findOne(request: ServerRequest): ServerResponse {
        val id = request.pathVariable("id").toInt()
        val product = products.getOrNull(id)

        return product?.let{
            ServerResponse.ok().bodyValueAndAwait(it)
        } ?: ServerResponse.notFound().buildAndAwait()
        /*
        val mono = Mono.just(products[id]).awaitFirstOrNull()
        return mono?.let{
            ServerResponse.ok().bodyValueAndAwait(it)
        } ?: ServerResponse.notFound().buildAndAwait()
        */
    }
}