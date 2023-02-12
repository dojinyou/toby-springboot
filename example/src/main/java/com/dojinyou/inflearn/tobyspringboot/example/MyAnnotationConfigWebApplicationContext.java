package com.dojinyou.inflearn.tobyspringboot.example;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    @Override
    public void onRefresh() {
        super.onRefresh();
        var serverFactory = (ServletWebServerFactory) new TomcatServletWebServerFactory();
        var webServer = serverFactory.getWebServer(servletContext -> {
                servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this)).addMapping("/*");
        });
        webServer.start();
    }
}
