package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description Spring Boot 整合filter
 **/
@WebFilter(filterName = "first",urlPatterns = {"/first"})
public class DemoFilter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("First Filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入First Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开First Filter");
    }

    @Override
    public void destroy() {
        System.out.println("First Filter结束");
    }
}
