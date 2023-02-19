package com.dojinyou.inflearn.tobyspringboot.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import javax.sql.DataSource

@JdbcTest
class DataSourceTest {

    @Autowired
    val dataSource: DataSource? = null

    @Test
    fun connect() {
        val connection = dataSource?.connection ?: throw AssertionError()
        connection.close()
    }
}
