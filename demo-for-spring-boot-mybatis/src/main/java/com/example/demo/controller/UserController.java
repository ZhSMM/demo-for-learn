package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/14
 * @description 用户管理Controller
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String addUser(@Validated User user, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list=result.getAllErrors();
            for (ObjectError objectError : list) {
                FieldError fieldError=(FieldError) objectError;
                String fieldName= fieldError.getField();
                String msg = fieldError.getDefaultMessage();
                System.out.println("fieldName + msg = " + fieldName+" ---- " + msg);
            }
            return "addUser";
        }
        try {
            userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

    @GetMapping("/showUser")
    public String showUser(Model model){
        List<User> users=null;
        try {
            users=userService.showUser();
            model.addAttribute("users",users);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "showUsers";
    }

    @GetMapping("/preupdate")
    public String preUpdate(Integer id,Model model){
        User user=null;
        try {
            user=userService.preUpdate(id);
            model.addAttribute("user",user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user){
        System.out.println(user.getUserid() + " "+user.getUsername() +" "+user.getUsersex());
        try {
            userService.modifiedUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        try {
            userService.deleteUser(id);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }
}
