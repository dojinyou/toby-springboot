package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HelloServiceCountTest {

    @Autowired
    lateinit var helloService: HelloService

    @Autowired
    lateinit var memberRepository: MemberRepository

    private val name = "dojin"

    @Test
    fun sayHelloIncreaseCount() {
        val prevCount = memberRepository.countOf(name)

        helloService.sayHello(name)

        Assertions.assertThat(memberRepository.countOf(name)).isEqualTo(prevCount + 1)
    }

}
