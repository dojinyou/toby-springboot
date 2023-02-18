package com.dojinyou.inflearn.tobyspringboot.config.autoconfig

import com.dojinyou.inflearn.tobyspringboot.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "server")
class ServerProperties {
    lateinit var contextPath: String
    lateinit var port: Number
}
