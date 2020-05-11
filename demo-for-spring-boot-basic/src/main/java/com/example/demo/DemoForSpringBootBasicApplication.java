package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 在Spring Boot启动时会扫描@WebServlet注解，并将该类实例化
public class DemoForSpringBootBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoForSpringBootBasicApplication.class, args);
    }

}
