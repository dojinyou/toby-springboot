package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.ConditionalMyOnClass
import com.dojinyou.inflearn.tobyspringboot.config.MyAutoConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MyAutoConfiguration
@ConditionalMyOnClass(value = "org.apache.catalina.startup.Tomcat")
class TomcatWebServerConfig(
    @Value(value = "\${contextPath}")
    val contextPath: String
) {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(env: Environment): ServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()
        factory.contextPath = this.contextPath

        return factory
    }
}
