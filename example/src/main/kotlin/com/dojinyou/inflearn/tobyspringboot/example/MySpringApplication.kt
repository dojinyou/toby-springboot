package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

class MySpringApplication {
}

inline fun<reified T: Any> runApplication(vararg args: String) {
    val applicationContext: AnnotationConfigWebApplicationContext = MyAnnotationConfigWebApplicationContext()
    applicationContext.register(T::class.java)
    applicationContext.refresh()
}
