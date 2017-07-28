package com.weituitu.demo08;

import com.weituitu.demo08.web.filter.LoginFilter;
import com.weituitu.demo08.web.listener.MyServletContextListener;
import com.weituitu.demo08.web.servlet.LoginServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

@SpringBootApplication //等同于@Configuration @EnableAutoConfiguration  @ComponentScan
@RestController
public class Demo08Application implements ServletContextInitializer {


    public static void main(String[] args) {
        SpringApplication.run(Demo08Application.class, args);
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("login", new LoginServlet()).addMapping("/login");
        servletContext.addFilter("loginFilter", new LoginFilter()).addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "login");
        servletContext.addListener(new MyServletContextListener());
    }
}
