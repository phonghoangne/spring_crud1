package com.app.springbootpractice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class MvcConfig {

    public void addResourceHandle(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:"+System.getProperty("user.dir")+"\\src\\uploads\\");
    }


}
