package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata
import kotlin.reflect.*

@MyAutoConfiguration
@Conditional(JettyWebServerConfig.JettyCondition::class)
class JettyWebServerConfig {
    object JettyCondition: Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return true
        }
    }

    @Bean("jettyWebServerFactory")
    fun servletSebServerFactory(): ServletWebServerFactory {
        return JettyServletWebServerFactory()
    }
}
