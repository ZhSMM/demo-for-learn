package org.example.demo.thread.reflect.reflect;

import org.example.demo.thread.reflect.entity.User;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 获取Class的方式
 * <p>
 * 常见的获取Class的方式：
 * 1. Object.getClass
 * 2. 直接通过类对象获取
 * 3. 通过类加载器获取：Class.forName
 **/

public class DemoGetClass {
    public static void main(String[] args) {
        // 1. 创建一个User实例，获取其Class对象
        Class<? extends User> c1 = new User().getClass();
        // 2. 直接通过类对象获取
        Class<User> c2 = User.class;
        // 3. 通过类加载器获取
        Class<?> c3 = null;
        try {
            c3 = Class.forName("org.example.entity.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 4.验证这三个Class对象是否为同一Class对象
        System.out.println("c1：" + c1.hashCode());   // 1670675563
        System.out.println("c2：" + c2.hashCode());   // 1670675563
        assert c3 != null;
        System.out.println("c3：" + c3.hashCode());   // 1670675563

        // 5.获取这个Class实例的加载器
        ClassLoader loader = c1.getClassLoader();
        System.out.println("User类的类加载器：" + loader);  // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 6.类加载器的父类以及父类
        System.out.println("User类加载器父类：" + loader.getParent());  // sun.misc.Launcher$ExtClassLoader@2b193f2d
        System.out.println("User类加载器父类的父类：" + loader.getParent().getParent());  // null

        // 7.Object类的类加载器
        System.out.println("Object类的类加载器:" + Object.class.getClassLoader());  // null

        // 8.int、float、boolean以及Integer、String等的类加载器
        //    均为null  ,即基本类型及其包装类 是由BootStrapClassLoader加载器加载
        System.out.println("int:" + int.class.getClassLoader());
        System.out.println("float:" + float.class.getClassLoader());
        System.out.println("boolean:" + boolean.class.getClassLoader());
        System.out.println("String:" + String.class.getClassLoader());
        System.out.println("Integer:" + Integer.class.getClassLoader());
        System.out.println("Boolean:" + Boolean.class.getClassLoader());
        System.out.println("Float:" + Float.class.getClassLoader());
    }
}
