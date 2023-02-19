package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class HelloDecorator(
    private val helloService: HelloService
): HelloService {


    override fun sayHello(name: String): String {
        val response = helloService.sayHello(name)
        return "* $response *"
    }

    override fun countOf(name: String): Int {
        return helloService.countOf(name)
    }
}
