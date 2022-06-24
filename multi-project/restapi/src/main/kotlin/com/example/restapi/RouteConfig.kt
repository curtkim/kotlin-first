package com.example.restapi

import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouteConfig {
    @FlowPreview
    @Bean
    fun routes(handler: Handler) = coRouter {
        GET("/add", handler::add)
    }
}