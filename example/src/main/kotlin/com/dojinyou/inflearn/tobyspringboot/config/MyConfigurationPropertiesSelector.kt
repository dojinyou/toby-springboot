package com.dojinyou.inflearn.tobyspringboot.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata
import kotlin.reflect.jvm.jvmName

class MyConfigurationPropertiesSelector: DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val attrs = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties::class.jvmName) ?: return emptyArray()
        val propertyClass = attrs.getFirst("value") as Class<*>

        return arrayOf(propertyClass.name)
    }

}
