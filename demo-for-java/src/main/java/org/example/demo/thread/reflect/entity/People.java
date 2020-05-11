package org.example.demo.thread.reflect.entity;

import java.util.UUID;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description Supper Class
 **/

public class People implements Study {
    public String id = UUID.randomUUID().toString();
    private String name;
    private Integer age;

    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void learn() {
        System.out.println(this.name + " is Studying!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
