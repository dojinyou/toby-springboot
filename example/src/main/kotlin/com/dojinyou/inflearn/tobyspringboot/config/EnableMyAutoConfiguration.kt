package com.dojinyou.inflearn.tobyspringboot.config

import com.dojinyou.inflearn.tobyspringboot.config.autoconfig.DispatcherServletConfig
import com.dojinyou.inflearn.tobyspringboot.config.autoconfig.TomcatWebServerConfig
import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(DispatcherServletConfig::class, TomcatWebServerConfig::class)
annotation class EnableMyAutoConfiguration
