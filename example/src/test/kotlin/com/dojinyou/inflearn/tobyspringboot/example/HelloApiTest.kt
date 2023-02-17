package com.dojinyou.inflearn.tobyspringboot.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class HelloApiTest {

	private val contextPath = "/api"
	private val port = 8888

	@Test
	fun contextLoads() {
		val rest = TestRestTemplate()

		val res = rest.getForEntity("http://localhost:$port$contextPath/hello?name={name}", String::class.java, "Spring")

		assertThat(res.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(res.headers[HttpHeaders.CONTENT_TYPE]!!.first()).startsWith(MediaType.TEXT_PLAIN_VALUE)
		assertThat(res.body).startsWith("* Hello Spring *")
	}


	@Test
	fun failApiTest() {
		val rest = TestRestTemplate()

		val res = rest.getForEntity("http://localhost:$port$contextPath/hello?name={name}", String::class.java, "")

		assertThat(res.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
	}

}
