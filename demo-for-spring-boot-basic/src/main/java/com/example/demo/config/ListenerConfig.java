package com.example.demo.config;

import com.example.demo.listener.DemoListener02;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description details
 **/
@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean getListener(){
        return new ServletListenerRegistrationBean(new DemoListener02());
    }
}
