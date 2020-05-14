package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper") // 指定扫描于接口映射配置文件的包名
public class DemoForSpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoForSpringBootMybatisApplication.class, args);
    }

}
