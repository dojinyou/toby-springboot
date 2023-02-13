package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

inline fun<reified T: Any> runApplication(vararg args: String) {
    val applicationContext: AnnotationConfigWebApplicationContext = MyAnnotationConfigWebApplicationContext()
    applicationContext.register(T::class.java)
    applicationContext.refresh()
}

@MySpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}
