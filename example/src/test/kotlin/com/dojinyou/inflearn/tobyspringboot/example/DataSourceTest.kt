package com.dojinyou.inflearn.tobyspringboot.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.lang.AssertionError
import javax.sql.DataSource

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ExampleApplication::class])
@TestPropertySource("classpath:/application.properties")
class DataSourceTest {

    @Autowired
    val dataSource: DataSource? = null

    @Test
    fun connect() {
        val connection = dataSource?.connection ?: throw AssertionError()
        connection.close()
    }
}
