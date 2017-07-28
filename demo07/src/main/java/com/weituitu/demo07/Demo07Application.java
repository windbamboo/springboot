package com.weituitu.demo07;

import com.weituitu.demo07.web.filter.LoginFilter;
import com.weituitu.demo07.web.listener.MyServletContextListener;
import com.weituitu.demo07.web.servlet.LoginServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //等同于@Configuration @EnableAutoConfiguration  @ComponentScan
@RestController
public class Demo07Application {


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new LoginServlet(), "/login");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        return new FilterRegistrationBean(new LoginFilter(), servletRegistrationBean());
    }

    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<MyServletContextListener>(new MyServletContextListener());
    }


    public static void main(String[] args) {
        SpringApplication.run(Demo07Application.class, args);
    }


}
