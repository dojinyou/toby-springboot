package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

@Configuration
@ComponentScan
class ExampleApplication {
    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }

    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }
}

fun main(args: Array<String>) {
    val applicationContext: AnnotationConfigWebApplicationContext = MyAnnotationConfigWebApplicationContext()
    applicationContext.register(ExampleApplication::class.java)
    applicationContext.refresh()
}
