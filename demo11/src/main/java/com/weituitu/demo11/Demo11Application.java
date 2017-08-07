package com.weituitu.demo11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication //等同于@Configuration @EnableAutoConfiguration  @ComponentScan
public class Demo11Application {


    public static void main(String[] args) {
        SpringApplication.run(Demo11Application.class, args);
    }


}
