package com.dojinyou.inflearn.tobyspringboot.example

import com.dojinyou.inflearn.tobyspringboot.config.MySpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import javax.annotation.PostConstruct

@MySpringBootApplication
class ExampleApplication(val jdbcTemplate: JdbcTemplate) {

    @PostConstruct
    fun init() {
        jdbcTemplate.execute(
            "create table if not exists member(name varchar(50) primary key, count int)"
        )
    }
}

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}
