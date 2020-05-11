package com.example.demo.config;

import com.example.demo.filter.DemoFilter02;
import com.example.demo.servlet.DemoServlet02;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description details
 **/
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new DemoFilter02());
//        bean.addUrlPatterns(new String[]{"/second","*.action"});
        bean.addUrlPatterns("/second");
        return bean;
    }
}
