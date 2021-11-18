package com.skc.labs;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {



    @Value("${camel.context.path:/camel}")
    private String contextPath;

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servlet = new ServletRegistrationBean();
        servlet.setName("camel-servlet");
        servlet.setLoadOnStartup(1);
        servlet.setServlet(new CamelHttpTransportServlet());
        servlet.addUrlMappings(contextPath);
        return servlet;
    }




}
