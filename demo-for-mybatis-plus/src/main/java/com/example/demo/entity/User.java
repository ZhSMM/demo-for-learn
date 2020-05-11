package com.example.demo.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Options;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description User实体
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
