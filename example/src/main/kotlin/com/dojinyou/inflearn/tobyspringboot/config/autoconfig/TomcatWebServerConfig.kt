package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata

@MyAutoConfiguration
@Conditional(TomcatWebServerConfig.TomcatCondition::class)
class TomcatWebServerConfig {
    object TomcatCondition: Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return false
        }
    }

    @Bean("tomcatWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }
}
