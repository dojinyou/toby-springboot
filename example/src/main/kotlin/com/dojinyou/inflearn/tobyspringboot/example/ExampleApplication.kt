package com.dojinyou.inflearn.tobyspringboot.example

import com.dojinyou.inflearn.tobyspringboot.config.MySpringBootApplication
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
