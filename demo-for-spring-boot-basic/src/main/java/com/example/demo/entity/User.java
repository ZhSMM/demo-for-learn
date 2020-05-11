package com.example.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description User类
 **/
@Data
@Component
@PropertySource(name = "user",value = "classpath:/config/user.properties",ignoreResourceNotFound = false,encoding = "UTF-8")
//@ConfigurationProperties(prefix = "user")
public class User {
    @Value("${user.uuid}")
    private String uuid;
    @Value("${user.age}")
    private int age;
    @Value("${user.hobby}")
    private String hobby;
}
