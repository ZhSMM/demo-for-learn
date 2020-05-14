package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/13
 * @description details
 **/
public interface UserService {
    void addUser(User user);
    List<User> findAll();
    User getUserById(Integer id);
    void updateUser(User user);
    void deleteById(Integer id);
}
