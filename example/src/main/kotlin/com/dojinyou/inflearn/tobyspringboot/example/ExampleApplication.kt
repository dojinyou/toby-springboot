package com.dojinyou.inflearn.tobyspringboot.example

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.registerBean
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExampleApplication

fun main(args: Array<String>) {
    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer({
        val applicationContext = GenericApplicationContext()
        applicationContext.registerBean<HelloController>()
        applicationContext.refresh()

        it.addServlet("hello", object : HttpServlet() {
            override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
                // 공통 처리

                // 요청 매핑
                if ((req!!.requestURI == "/hello") && (req.method == HttpMethod.GET.name)) {
                    val name = req.getParameter("name") ?: "servlet"
                    // 로직 처리를 위한 binding
                    val helloController = applicationContext.getBean(HelloController::class.java)
                    val result = helloController.hello(name)

                    resp!!.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                    resp.writer!!.println(result)
                } else {
                    resp!!.status = HttpStatus.NOT_FOUND.value()
                }

            }
        }).addMapping("/*")
    })

    webServer.start()
}
