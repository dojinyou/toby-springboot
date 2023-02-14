package com.dojinyou.inflearn.tobyspringboot.config

import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Configuration(proxyBeanMethods = false)
annotation class MyAutoConfiguration {
}
