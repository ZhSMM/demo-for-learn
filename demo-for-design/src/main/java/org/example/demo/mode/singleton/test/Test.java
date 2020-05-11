package org.example.demo.mode.singleton.test;

import org.example.demo.designer.singleton.innerclasssingleton.InnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 利用反射来测试单例模式
 **/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<InnerClassSingleton> constructor = InnerClassSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        // 通过反射使用构造函数实例化
        InnerClassSingleton innerClassSingleton = constructor.newInstance();
        // 使用getInstance()方法实例化
        InnerClassSingleton innerClassSingleton1=InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == innerClassSingleton1);  // false
    }
}
