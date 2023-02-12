package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

@Configuration
class ExampleApplication {

    @Bean
    fun helloController(helloService: HelloService): HelloController = HelloController(helloService)

    @Bean
    fun helloService(): HelloService = SimpleHelloService()
}

fun main(args: Array<String>) {
    val applicationContext: AnnotationConfigWebApplicationContext = MyAnnotationConfigWebApplicationContext()
    applicationContext.register(ExampleApplication::class.java)
    applicationContext.refresh()
}
