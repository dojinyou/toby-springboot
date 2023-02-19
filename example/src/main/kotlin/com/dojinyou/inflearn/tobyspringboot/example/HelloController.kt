package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    val service: HelloService
) {

    @GetMapping("/hello")
    fun hello(name: String): String {
        if(name.isBlank()) {
            throw IllegalArgumentException()
        }

        return service.sayHello(name)
    }

    @GetMapping("/count")
    fun countOf(name: String): Int {
        if(name.isBlank()) {
            throw IllegalArgumentException()
        }

        return service.countOf(name)
    }
}
