package com.dojinyou.inflearn.tobyspringboot.example

interface HelloService {
    fun sayHello(name: String): String
    fun countOf(name: String): Int
}
