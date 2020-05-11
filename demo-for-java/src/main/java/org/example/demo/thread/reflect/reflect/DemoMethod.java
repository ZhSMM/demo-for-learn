package org.example.demo.thread.reflect.reflect;

import org.example.demo.thread.reflect.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 方法字段
 **/
public class DemoMethod {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<User> userClass = User.class;
        Method setId = userClass.getDeclaredMethod("setId", Integer.class);
        User user = userClass.newInstance();
        setId.invoke(user, 18);

        Method hello = userClass.getDeclaredMethod("hello");
        hello.setAccessible(true);  // 私有方法需要解除验证
        hello.invoke(user);

        System.out.println(user);
    }
}
