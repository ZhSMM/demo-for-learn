package org.example.demo.thread.reflect.reflect;

import org.example.demo.thread.reflect.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 通过反射创建对象
 * 1. 通过Class.newInstance创建对象：该类需要存在非空构造
 * 2. 通过构造器创建对象
 **/
public class DemoNewInstance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 获取Class实例
        Class<User> userClass = User.class;
        // 1. 通过Class实例无参构造创建实例
        User user1 = userClass.newInstance();
        System.out.println(user1);

        // 2. 通过构造器创建实例
        Constructor<User> constructor = userClass.getConstructor(null);
        User user = constructor.newInstance();
        System.out.println(user);
    }
}
