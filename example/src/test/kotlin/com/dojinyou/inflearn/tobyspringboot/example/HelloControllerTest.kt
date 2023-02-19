package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloControllerTest {

    private val helloServiceStub = object : HelloService {
        override fun sayHello(name: String) = name
        override fun countOf(name: String): Int = 0
    }

    @Test
    fun simpleHelloController() {
        val controller = HelloController(helloServiceStub)

        val name = "Spring"
        val res = controller.hello(name)

        assertThat(res).isEqualTo(name)
    }


    @Test
    fun failHelloController() {
        val controller = HelloController(helloServiceStub)
        val name = ""
        Assertions.assertThatThrownBy {
            controller.hello(name)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

}
