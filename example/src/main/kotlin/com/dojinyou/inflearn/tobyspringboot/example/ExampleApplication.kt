package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

@Configuration
@ComponentScan
class ExampleApplication {
}

fun main(args: Array<String>) {
    val applicationContext: AnnotationConfigWebApplicationContext = MyAnnotationConfigWebApplicationContext()
    applicationContext.register(ExampleApplication::class.java)
    applicationContext.refresh()
}
