package com.dojinyou.inflearn.tobyspringboot.config

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils
import kotlin.reflect.jvm.jvmName


class MyOnClassCondition: Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val attr = metadata.getAnnotationAttributes(ConditionalMyOnClass::class.jvmName)
        val value = attr!!["value"].toString()

        return ClassUtils.isPresent(value, context.classLoader)
    }

}
