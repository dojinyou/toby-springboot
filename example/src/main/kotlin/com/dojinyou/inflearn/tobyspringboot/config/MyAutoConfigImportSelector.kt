package com.dojinyou.inflearn.tobyspringboot.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyAutoConfigImportSelector: DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        return arrayOf(
            "com.dojinyou.inflearn.tobyspringboot.config.autoconfig.DispatcherServletConfig",
            "com.dojinyou.inflearn.tobyspringboot.config.autoconfig.TomcatWebServerConfig"
        )
    }
}
