package com.dojinyou.inflearn.tobyspringboot.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import javax.sql.DataSource

@HelloBootTest
class DataSourceTest {

    @Autowired
    val dataSource: DataSource? = null

    @Test
    fun connect() {
        val connection = dataSource?.connection ?: throw AssertionError()
        connection.close()
    }
}
