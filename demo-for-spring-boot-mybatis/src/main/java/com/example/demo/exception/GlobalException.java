package com.example.demo.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/14
 * @description 全局异常处理类
 **/
//@ControllerAdvice
@Configuration
public class GlobalException {
//    @ExceptionHandler(value = {java.lang.NullPointerException.class, java.lang.ArithmeticException.class})
//    public ModelAndView exceptionHandler(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("err", e.toString());
//        modelAndView.setViewName("errorNull");
//        return modelAndView;
//    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
       SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
        Properties properties=new Properties();
        /**
         * 参数一：异常类型，并且是全名
         * 参数二：视图名称
         */
        properties.put("java.lang.NullPointerException","errorNull");
        properties.put("java.lang.ArithmeticException","errorNull");

        resolver.setExceptionMappings(properties);
        return resolver;
    }

}
