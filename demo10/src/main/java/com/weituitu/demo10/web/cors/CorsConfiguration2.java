package com.weituitu.demo10.web.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by liuguozhu on 2017/8/2.
 */
//@Configuration
public class CorsConfiguration2 extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v1/**").allowedOrigins("http://localhost");
    }
}
