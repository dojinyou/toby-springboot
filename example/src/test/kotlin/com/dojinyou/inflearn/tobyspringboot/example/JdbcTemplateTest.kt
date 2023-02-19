package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate

@JdbcTest
class JdbcTemplateTest {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @BeforeEach
    fun init() {
        jdbcTemplate.execute(
            "create table if not exists member(name varchar(50) primary key, count int)"
        )
    }

    @Test
    fun insertAndQuery() {
        jdbcTemplate.update("insert into member values(?, ?)", "toby", 3)
        jdbcTemplate.update("insert into member values(?, ?)", "spring", 1)

        val count = jdbcTemplate.queryForObject("select count(*) from member", Long::class.java)
        Assertions.assertThat(count).isEqualTo(2)
    }

    @Test
    fun insertAndQuery2() {
        jdbcTemplate.update("insert into member values(?, ?)", "toby2", 3)
        jdbcTemplate.update("insert into member values(?, ?)", "spring2", 1)

        val count = jdbcTemplate.queryForObject("select count(*) from member", Long::class.java)
        Assertions.assertThat(count).isEqualTo(2)
    }
}
