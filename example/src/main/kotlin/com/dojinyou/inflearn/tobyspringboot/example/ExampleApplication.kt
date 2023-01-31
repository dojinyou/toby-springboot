package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.beans.factory.support.BeanNameGenerator
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.registerBean
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

@Configuration
class ExampleApplication {

    @Bean
    fun helloController(helloService: HelloService): HelloController = HelloController(helloService)

    @Bean
    fun helloService(): HelloService = SimpleHelloService()
}

fun main(args: Array<String>) {
    val applicationContext = object: AnnotationConfigWebApplicationContext() {
        override fun onRefresh() {
            super.onRefresh()
            val serverFactory = TomcatServletWebServerFactory()
            val webServer = serverFactory.getWebServer({
                it.addServlet("dispatcherServlet", DispatcherServlet(this))
                    .addMapping("/*")
            })

            webServer.start()
        }
    }

    applicationContext.register(ExampleApplication::class.java)
    applicationContext.refresh()
}
