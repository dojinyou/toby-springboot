package com.dojinyou.inflearn.tobyspringboot.config

import org.springframework.context.annotation.Conditional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Conditional(MyOnClassCondition::class)
annotation class ConditionalMyOnClass(val value: String)
