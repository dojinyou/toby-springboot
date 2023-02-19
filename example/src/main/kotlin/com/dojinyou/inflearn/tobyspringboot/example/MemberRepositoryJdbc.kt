package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class MemberRepositoryJdbc(
    private val jdbcTemplate: JdbcTemplate
): MemberRepository {
    override fun findMember(name: String): Member? {
        return try {
            this.jdbcTemplate.queryForObject(
                "select * from member where name = '$name'"
            ) { rs: ResultSet, _: Int -> Member(rs.getString("name"), rs.getInt("count")) }
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    override fun increaseCount(name: String) {
        val member = findMember(name)

        if (member == null) {
            createMember(name)
            return
        }

        jdbcTemplate.update("update member set count = ? where name = ?", member.getCount() + 1, name)


    }

    private fun createMember(name: String) {
        jdbcTemplate.update("insert into member values(?, ?)", name, 1)
    }
}
