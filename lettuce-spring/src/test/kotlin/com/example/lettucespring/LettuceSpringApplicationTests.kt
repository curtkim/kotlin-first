package com.example.lettucespring

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class LettuceSpringApplicationTests(val context: ApplicationContext) {


	@Test
	fun contextLoads() {
		context.beanDefinitionNames.forEach { println(it + " " + context.getBean(it)::class.java.name) }
	}

}
