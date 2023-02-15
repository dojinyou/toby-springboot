package com.dojinyou.inflearn.tobyspringboot.example.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import kotlin.reflect.jvm.jvmName

class ConditionalTest {

    @Test
    fun conditionalTrue() {
        val contextRunner = ApplicationContextRunner()
        contextRunner.withUserConfiguration(Config1::class.java)
            .run {
                Assertions.assertThat(it).hasSingleBean(MyBean::class.java)
                Assertions.assertThat(it).hasSingleBean(Config1::class.java)
            }
    }

    @Test
    fun conditionalFalse() {
        val contextRunner = ApplicationContextRunner()
        contextRunner.withUserConfiguration(Config2::class.java)
            .run {
                Assertions.assertThat(it).doesNotHaveBean(MyBean::class.java)
                Assertions.assertThat(it).doesNotHaveBean(Config2::class.java)
            }
    }

    @Configuration
    @BooleanConditional(true)
    class Config1{
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    @Configuration
    @BooleanConditional(false)
    class Config2{
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    class MyBean {
    }

    class BooleanCondition: Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            val annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional::class.jvmName)
            return annotationAttributes!!["value"] as Boolean
        }
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(val value: Boolean) {
    }


}
