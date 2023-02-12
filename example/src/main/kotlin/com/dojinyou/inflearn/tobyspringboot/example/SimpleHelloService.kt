package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.stereotype.Component

@Component
class SimpleHelloService : HelloService {
    override fun sayHello(name: String) = "Hello $name"
}
