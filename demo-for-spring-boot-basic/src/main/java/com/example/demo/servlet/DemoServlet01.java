package com.example.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description Spring Boot 整合Servlet方式一:通过注解扫描完成Servlet组件的注册：@WebServlet
 **/
@WebServlet(name = "FirstServlet",urlPatterns = "/first")
public class DemoServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("第一个Servlet启动");
        resp.getWriter().print("Hello");
    }
}
