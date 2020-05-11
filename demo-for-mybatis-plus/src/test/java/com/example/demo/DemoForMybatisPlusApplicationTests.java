package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class DemoForMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    private Random random=new Random();
    @Test
    void contextLoads() {
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);
        int size = users.size();

        int randomInt=random.nextInt(1000000000);
        User user=new User();
        user.setName("username@"+randomInt);
        user.setAge(randomInt/10000000);

        user.setEmail(randomInt+"@qq.com");
        user.setId((long) (size+1));
        userMapper.insert(user);
    }
     

}
