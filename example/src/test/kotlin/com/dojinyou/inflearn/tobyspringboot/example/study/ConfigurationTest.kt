package com.dojinyou.inflearn.tobyspringboot.example.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigurationTest {

    @Test
    fun configuration() {
        val applicationContext = AnnotationConfigApplicationContext()
        applicationContext.register(MyConfig::class.java)
        applicationContext.refresh()

        val bean1 = applicationContext.getBean(Bean1::class.java)
        val bean2 = applicationContext.getBean(Bean2::class.java)

        assertThat(bean1.common).isEqualTo(bean2.common)
    }

    @Test
    fun proxyCommonMethod() {
        val myConfigProxy = MyConfigProxy()

        val bean1 = myConfigProxy.bean1()
        val bean2 = myConfigProxy.bean2()

        assertThat(bean1.common).isEqualTo(bean2.common)
    }

    companion object {
        class MyConfigProxy : MyConfig() {
            private var common: Common? = null

            override fun common(): Common {
                if (this.common == null) {
                    this.common = super.common()
                }

                return this.common!!
            }
        }

        @Configuration
        class MyConfig {
            @Bean
            fun common(): Common {
                return Common()
            }

            @Bean
            fun bean1(): Bean1 {
                return Bean1(common())
            }

            @Bean
            fun bean2(): Bean2 {
                return Bean2(common())
            }
        }


        class Common {}

        class Bean1(
            val common: Common
        ) {}

        class Bean2(
            val common: Common
        ) {}
    }

}
