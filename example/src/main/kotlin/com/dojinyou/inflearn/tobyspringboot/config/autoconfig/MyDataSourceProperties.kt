package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "data")
class MyDataSourceProperties {
    lateinit var driverClassName:String
    lateinit var url:String
    lateinit var username:String
    lateinit var password:String
}
