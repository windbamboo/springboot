package com.weituitu.demo10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication //等同于@Configuration @EnableAutoConfiguration  @ComponentScan
public class Demo10Application {


    public static void main(String[] args) {
        SpringApplication.run(Demo10Application.class, args);
    }


}
