package org.example.demo.thread.reflect.reflect;

import org.example.demo.thread.reflect.entity.People;
import org.example.demo.thread.reflect.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 通过反射获取方法、属性、注解等
 **/
public class DemoReflect {

    // 获取属性
    public static void TestField(Class<?> clazz) {
        // 1. Class.getFields():获得某个类的所有的公共（public）的字段，包括父类中的字段。
        Field[] fields = clazz.getFields();

        // 2. Class.getDeclaredFields():获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("getFields()方法:" + field);
        }
        for (Field declaredField : declaredFields) {
            System.out.println("getDeclaredFields()方法:" + declaredField);
        }
    }

    // 获取方法
    public static void TestMethod(Class<?> clazz) {
        // 1. Class.getMethods():该方法是获取本类以及父类或者父接口中所有的公共方法(public修饰符修饰的)
        Method[] methods = clazz.getMethods();

        // 2. Class.getDeclaredFields():方法是获取本类中的所有方法，包括私有的(private、protected、默认以及public)的方法。
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("getMethod()方法:" + method);
        }
        for (Method declaredMethod : declaredMethods) {
            System.out.println("getDeclaredMethod()方法：" + declaredMethod);
        }
    }

    // 获取构造方法
    public static void TestConstructor(Class<?> clazz) {
        // 获取所有构造函数
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == 0) {
                System.out.println(clazz.getName() + "的无参构造函数：" + constructor);
            } else {
                System.out.println(clazz.getName() + "的有参构造函数：" + constructor);
            }
        }
        // 获取无参构造函数
        Constructor<?> constructor = null;
        try {
            constructor = clazz.getConstructor(null);
            System.out.println(clazz.getSimpleName() + "的无参构造：" + constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    // 获取父类
    public static void TestParent(Class<?> clazz) {
        // 得到接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口：" + anInterface);
        }
        // 得到父类
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("父类：" + superclass);
    }

    public static void main(String[] args) {
        TestField(User.class);
        TestMethod(User.class);
        TestConstructor(User.class);
        TestParent(People.class);
    }
}
