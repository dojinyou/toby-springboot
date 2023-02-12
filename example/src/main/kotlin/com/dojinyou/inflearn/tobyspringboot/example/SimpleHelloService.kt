package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.stereotype.Service

@Service
class SimpleHelloService : HelloService {
    override fun sayHello(name: String): String {
        if (name.isBlank()) {
            throw IllegalArgumentException()
        }
        return "Hello $name"
    }
}
