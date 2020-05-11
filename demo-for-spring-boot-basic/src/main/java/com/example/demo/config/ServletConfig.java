package com.example.demo.config;

import com.example.demo.servlet.DemoServlet02;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description 完成Servlet组件的注册
 **/
@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        return new ServletRegistrationBean(new DemoServlet02(), "/second");
    }
}
