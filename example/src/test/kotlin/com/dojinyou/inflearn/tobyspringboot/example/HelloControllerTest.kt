package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloControllerTest {

    @Test
    fun simpleHelloController() {
        val controller = HelloController(object : HelloService {
            override fun sayHello(name: String) = name
        })

        val name = "Spring"
        val res = controller.hello(name)

        assertThat(res).isEqualTo(name)
    }


    @Test
    fun failHelloController() {
        val controller = HelloController(object : HelloService {
            override fun sayHello(name: String) = name
        })
        val name = ""
        Assertions.assertThatThrownBy {
            controller.hello(name)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

}
