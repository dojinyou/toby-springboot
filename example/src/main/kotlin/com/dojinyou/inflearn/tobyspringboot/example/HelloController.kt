package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Component
@RequestMapping("/hello")
class HelloController(
    val service: HelloService
) {
    @GetMapping
    @ResponseBody
    fun hello(name: String): String {
        return service.sayHello(name)
    }
}
