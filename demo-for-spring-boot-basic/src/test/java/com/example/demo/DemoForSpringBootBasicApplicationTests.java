package com.example.demo;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoForSpringBootBasicApplicationTests {

    @Resource
    private User user;
    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
