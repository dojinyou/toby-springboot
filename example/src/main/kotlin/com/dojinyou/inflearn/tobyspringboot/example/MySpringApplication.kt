package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import kotlin.reflect.KClass

class MySpringApplication {

    companion object {
        fun<T: Any> runApplication(classApplication: KClass<T>, vararg args: Array<String>) {
            val applicationContext: AnnotationConfigWebApplicationContext = MyAnnotationConfigWebApplicationContext()
            applicationContext.register(classApplication.java)
            applicationContext.refresh()
        }
    }
}
