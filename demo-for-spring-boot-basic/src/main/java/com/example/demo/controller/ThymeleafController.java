package com.example.demo.controller;

import com.example.demo.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/12
 * @description 测试thymeleaf
 **/
@Controller
public class ThymeleafController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("/index")
    public String showPage(Model model) {
        model.addAttribute("msg", "Thymeleaf测试");
        model.addAttribute("date", new java.util.Date());
        Random random = new Random();
        Map<String, Hello> map = new HashMap<>();
        List<Hello> list = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            list.add(new Hello(i, String.valueOf(random.nextInt(1000))));
            map.put("第" + i + "条", list.get(i));
        }
        model.addAttribute("list", list);
        model.addAttribute("map", map);

        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("ses","HttpServletRequest.session");
        request.getSession().getServletContext().setAttribute("app","Application");
        model.addAttribute("id",10);
        return "index";
    }

    @GetMapping("/test")
    public @ResponseBody Map<Integer,String> getUser(@RequestParam Integer id,@RequestParam String name){
        Map<Integer,String> map =new HashMap<>();
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            map.put(id+i,name+String.valueOf(random.nextInt(1000)));
        }
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return map;
    }
    @GetMapping("/hello/{id}/{name}")
    public @ResponseBody Map<Integer,String> getHello(@PathVariable Integer id, @PathVariable String name){
        Map<Integer,String> map =new HashMap<>();
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            map.put(id+i,name+String.valueOf(random.nextInt(1000)));
        }
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return map;
    }
}
