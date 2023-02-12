package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloServiceTest {

    @Test
    fun simpleHelloService() {
        val service = SimpleHelloService()

        val res = service.sayHello("Spring")

        assertThat(res).isEqualTo("Hello Spring")
    }
}
