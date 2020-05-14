package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/13
 * @description 页面跳转
 **/
@Controller
public class PageController {
    /**
     * 页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
//        String str = null;
//        str.length();
        return page;
    }
}
