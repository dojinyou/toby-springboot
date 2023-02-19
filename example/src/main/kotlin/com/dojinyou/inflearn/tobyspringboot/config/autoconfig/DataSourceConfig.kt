package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.ConditionalMyOnClass
import com.dojinyou.inflearn.tobyspringboot.config.EnableMyConfigurationProperties
import com.dojinyou.inflearn.tobyspringboot.config.MyAutoConfiguration
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import java.sql.Driver
import javax.sql.DataSource

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties::class)
class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    fun hikariDataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = HikariDataSource()

        dataSource.driverClassName = properties.driverClassName
        dataSource.jdbcUrl = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = SimpleDriverDataSource()

        val driverClass = Class.forName(properties.driverClassName) as Class<out Driver>
        dataSource.setDriverClass(driverClass)
        dataSource.url = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

}
