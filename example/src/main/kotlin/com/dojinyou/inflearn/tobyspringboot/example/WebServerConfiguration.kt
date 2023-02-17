package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class WebServerConfiguration {
    @Bean
    fun customWebServerFactory(): ServletWebServerFactory {
        val servletWebServerFactory = TomcatServletWebServerFactory()
        servletWebServerFactory.port = 9090

        return servletWebServerFactory
    }
}
