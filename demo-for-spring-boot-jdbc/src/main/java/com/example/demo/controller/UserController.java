package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/13
 * @description details
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name,
                          @RequestParam String sex) {
        User user=new User();
        user.setUserName(name);
        user.setUserSex(sex);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }
    // 查询所有用户
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> users=null;
        try {
            users = userService.findAll();
            model.addAttribute("users",users);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "showUsers";
    }
    // 预更新用户的查询
    @RequestMapping("/preupdate")
    public String preUpdate(Integer id,Model model){
        try {
            User user = this.userService.getUserById(id);
            model.addAttribute("user",user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "updateUser";
    }
    // 更新用户
    @PostMapping("/updateUser")
    public String updateUser(User user){
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }
    @GetMapping("/delete")
    public String deleteUser(Integer id){
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }
}
