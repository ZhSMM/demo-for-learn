package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/14
 * @description 页面跳转方法
 **/
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String pageController(@PathVariable String page) {
//        String str=null;
//        str.length();
        return page;
    }
}
