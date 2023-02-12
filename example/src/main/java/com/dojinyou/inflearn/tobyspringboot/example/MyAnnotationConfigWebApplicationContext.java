package com.dojinyou.inflearn.tobyspringboot.example;

import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    @Override
    public void onRefresh() {
        super.onRefresh();
        var serverFactory = this.getBean(ServletWebServerFactory.class);
        var dispatcherServlet = this.getBean(DispatcherServlet.class);
        dispatcherServlet.setApplicationContext(this);

        var webServer = serverFactory.getWebServer(servletContext -> {
                servletContext.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/*");
        });
        webServer.start();
    }
}
