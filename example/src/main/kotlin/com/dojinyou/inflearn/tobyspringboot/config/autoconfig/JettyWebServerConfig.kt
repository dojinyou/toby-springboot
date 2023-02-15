package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@MyAutoConfiguration
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    fun servletSebServerFactory(): ServletWebServerFactory {
        return JettyServletWebServerFactory()
    }
}
