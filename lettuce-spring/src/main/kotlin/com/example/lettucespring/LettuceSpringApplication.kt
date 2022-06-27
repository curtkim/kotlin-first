package com.example.lettucespring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LettuceSpringApplication

fun main(args: Array<String>) {
	runApplication<LettuceSpringApplication>(*args)
}
