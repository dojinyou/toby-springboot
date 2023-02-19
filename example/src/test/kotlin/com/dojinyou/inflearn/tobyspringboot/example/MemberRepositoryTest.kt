package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@HelloBootTest
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
        Assertions.assertThat(memberRepository.findMember(name)).isNull()
    }


    @Test
    fun increaseCount() {
        val origin = memberRepository.countOf(name)

        memberRepository.increaseCount(name)

        Assertions.assertThat(memberRepository.countOf(name)).isEqualTo(origin+1)
    }
}
