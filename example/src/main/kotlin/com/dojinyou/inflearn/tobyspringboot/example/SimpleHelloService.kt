package com.dojinyou.inflearn.tobyspringboot.example

class SimpleHelloService : HelloService {
    override fun sayHello(name: String) = "Hello $name"
}
