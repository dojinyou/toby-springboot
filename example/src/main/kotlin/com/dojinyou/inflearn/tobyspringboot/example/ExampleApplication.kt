package com.dojinyou.inflearn.tobyspringboot.example

import com.dojinyou.inflearn.tobyspringboot.config.MySpringBootApplication
import org.springframework.boot.runApplication

@MySpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}
