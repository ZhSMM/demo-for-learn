package com.example.demo.service;

import com.example.demo.dto.User;

import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/14
 * @description 用户Service
 **/
public interface UserService {
    void addUser(User user);
    List<User> showUser();
    User preUpdate(Integer id);
    void modifiedUser(User user);
    void deleteUser(Integer id);
}
