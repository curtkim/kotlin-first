package com.example.spring_functional_web

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

// productRoutes RouterFunction을 받으려고 했는데, 잘 안됨.
@SpringBootTest
class RouteHandlerTest(
                       val context: ApplicationContext) {

    @Test
    fun `list context`(){
        for(name in context.beanDefinitionNames.sorted()) {
            println("$name : ${context.getBean("productRoutes").javaClass.name}")
        }
    }

    /*
    @Test
    fun `get product list`(){
        val productRoutes: RouterFunction<ServerResponse> = null
        val testClient = WebTestClient.bindToRouterFunction(productRoutes).build()

        testClient.get().uri("/")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBodyList(Product::class.java)
    }

     */
}