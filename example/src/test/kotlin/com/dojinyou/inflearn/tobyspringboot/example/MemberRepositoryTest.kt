package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MemberRepositoryTest {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Autowired
    lateinit var memberRepository: MemberRepository

    private val name = "dojin"

    @BeforeEach
    fun init() {
        jdbcTemplate.execute(
            "create table if not exists member(name varchar(50) primary key, count int)"
        )
    }

    @Test
    fun findMemberFailed() {
        val newName = "newName"
        Assertions.assertThat(memberRepository.findMember(newName)).isNull()
    }


    @Test
    fun increaseCount() {
        val origin = memberRepository.countOf(name)

        memberRepository.increaseCount(name)

        Assertions.assertThat(memberRepository.countOf(name)).isEqualTo(origin+1)
    }
}
