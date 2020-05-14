package com.example.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer // 开启Spring Boot Admin 服务端
public class DemoForSpringBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoForSpringBootAdminApplication.class, args);
    }

}
