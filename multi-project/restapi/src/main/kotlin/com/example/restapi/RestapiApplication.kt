package com.example.restapi

import com.example.core.Adder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RestapiApplication{

    @Bean
    fun adder(): Adder {
        return com.example.core.Adder()
    }
}

fun main(args: Array<String>) {
    runApplication<RestapiApplication>(*args)
}
