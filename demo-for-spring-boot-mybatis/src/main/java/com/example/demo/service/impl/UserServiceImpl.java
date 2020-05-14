package com.example.demo.service.impl;

import com.example.demo.dto.User;
import com.example.demo.dto.UserExample;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/14
 * @description User Service Implementation
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user) {
        this.userMapper.insert(user);
    }

    @Override
    @Transactional
    public List<User> showUser() {
        UserExample example = new UserExample();
        return this.userMapper.selectByExample(example);
    }

    @Override
    public User preUpdate(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void modifiedUser(User user) {
        this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

}
