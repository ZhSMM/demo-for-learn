package org.example.demo.thread.reflect.reflect;

import org.example.demo.thread.reflect.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 通过反射对属性进行操作
 * <p>
 * 1. 获取字段的名称： String fieldName = field.getName();
 * 2. 获取字段的修饰符：int fieldValue = field.getModifiers(); //如：private、static、final等
 * 3. 与某个具体的修饰符进行比较：Modifier.isStatic(fieldValue) //看此修饰符是否为静态(static)
 * 4. 获取字段的声明类型：field.getType()；//返回的是一个class
 * 5. 与某个类型进行比较：field.getType() == Timestamp.class
 * 6. 获取指定对象中此字段的值：Object fieldObject= field.get(user);//user可以看做是从数据库中查找出来的对象
 **/
public class DemoField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 1. 通过反射获取Class对象
        Class<User> user = User.class;
        // 2. 获取属性
        Field[] fields = user.getDeclaredFields();
        // 3. 获取字段名称
        Field id = null;
        for (Field field : fields) {
            if ("id".equals(field.getName())) {
                id = field;
            }
        }
        // 4. 获取属性的修饰符
        assert id != null;
        int modifiers = id.getModifiers();
        System.out.println(id.getName() + "的修饰符：" + modifiers);
        // 5. 与某个具体的修饰符进行比较：Modifier.isStatic(fieldValue)
        System.out.println(Modifier.isStatic(modifiers) + " " + Modifier.isPrivate(modifiers));
        // 6. 获取字段的声明类型：field.getType()；
        Class<?> type = id.getType();
        System.out.println("id的类型：" + type);
        // 7. 设置属性
        // 8. 接触验证，对私有属性设置时需要
        if (!id.isAccessible()) {
            id.setAccessible(true);  // 默认false，需要进行验证 ；true，不需要验证
        }
        // 9.创建user实例
        User user1 = user.newInstance();
        // 设置属性值
        id.set(user1, 10);
        // 得到属性值
        System.out.println(id.get(user1));
    }
}
