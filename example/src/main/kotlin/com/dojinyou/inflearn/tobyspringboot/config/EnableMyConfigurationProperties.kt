package com.dojinyou.inflearn.tobyspringboot.config

import org.springframework.context.annotation.Import
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(MyConfigurationPropertiesSelector::class)
annotation class EnableMyConfigurationProperties(val value: KClass<*>)
