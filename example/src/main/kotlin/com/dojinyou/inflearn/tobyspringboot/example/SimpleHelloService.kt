package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.stereotype.Service

@Service
class SimpleHelloService(
    private val memberRepository: MemberRepository
) : HelloService {
    override fun sayHello(name: String): String {
        if (name.isBlank()) {
            throw IllegalArgumentException()
        }

        memberRepository.increaseCount(name)

        return "Hello $name"
    }

    override fun countOf(name: String): Int {
        if (name.isBlank()) {
            throw IllegalArgumentException()
        }

        return memberRepository.countOf(name)
    }
}
