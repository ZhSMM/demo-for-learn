package com.example.demo.dao;

import com.example.demo.pojo.User;

import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/13
 * @description details
 **/
public interface UserDao {
    void addUser(User user);
    List<User> findAll();
    User selectById(Integer id);
    void updateById(User user);
    void deleteById(Integer id);
}
