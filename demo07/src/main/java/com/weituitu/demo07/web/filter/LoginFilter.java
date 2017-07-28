package com.weituitu.demo07.web.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Created by liuguozhu on 2017/7/27.
 */
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter################################");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
