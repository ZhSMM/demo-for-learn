package org.example.demo.thread.reflect.entity;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 测试类
 **/
public class User extends People{
    private Integer id;
    public String userAccount="user";
    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, Integer age, Integer id) {
        super(name, age);
        this.id = id;
    }

    private void hello(){
        System.out.println("Hello!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "} " + super.toString();
    }
}
