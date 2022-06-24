package com.example.spring_functional_web

import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouteConfig {

    @FlowPreview
    @Bean
    fun productRoutes(handler: Handler) = coRouter {
        GET("/", handler::findAll)
        GET("/{id}", handler::findOne)
    }
}