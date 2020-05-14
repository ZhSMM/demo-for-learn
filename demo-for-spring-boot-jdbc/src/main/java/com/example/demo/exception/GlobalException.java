package com.example.demo.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/14
 * @description 全局异常处理
 **/
@Configuration
public class GlobalException implements HandlerExceptionResolver {
    /**
     * 通过if/else语句进行异常与视图的映射
     * @param httpServletRequest Request
     * @param httpServletResponse Response
     * @param handler Controller
     * @param e Exception
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        ModelAndView mv=new ModelAndView();
        // 判断不同异常类型，做不同视图的跳转
        if (e instanceof NullPointerException || e instanceof ArithmeticException){
            mv.addObject("error",e.toString());
            mv.setViewName("null");
        }else{
            mv.setViewName("error");
        }
        return mv;
    }
}
