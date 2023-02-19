package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloServiceTest {

    private val memberRepositoryStub = object: MemberRepository {
        override fun findMember(name: String): Member? {
            return null
        }

        override fun increaseCount(name: String) {
        }

    }

    @Test
    fun simpleHelloService() {
        val service = SimpleHelloService(memberRepositoryStub)

        val res = service.sayHello("Spring")

        assertThat(res).isEqualTo("Hello Spring")
    }

    @Test
    fun helloDecorator() {
        val service = HelloDecorator(SimpleHelloService(memberRepositoryStub))

        val res = service.sayHello("Spring")

        assertThat(res).isEqualTo("* Hello Spring *")
    }
}
