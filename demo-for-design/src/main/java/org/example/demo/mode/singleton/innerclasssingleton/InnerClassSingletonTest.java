package org.example.demo.mode.singleton.innerclasssingleton;

import java.io.*;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 内部类单例测试
 **/
public class InnerClassSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        // 多线程环境
//        new Thread(() -> {
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).start();
//
//        new Thread(() -> {
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).start();

        // 序列化会破坏单例模式
        // 写入单例模式实例
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("test"));
        oos.writeObject(instance);
        oos.close();

        // 读取单例实例
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("test"));
        InnerClassSingleton singleton = (InnerClassSingleton) ois.readObject();
        ois.close();
        // 对比序列化前后是否为同一实例
        System.out.println("(instance==singleton) = " + (instance == singleton));  // false：破坏了单例

        // 写入单例模式实例,经过修改后的单例
        InnerClassSingletonSerializable instanceSerializable = InnerClassSingletonSerializable.getInstance();
        ObjectOutputStream oos1=new ObjectOutputStream(new FileOutputStream("testSerializable"));
        oos1.writeObject(instanceSerializable);
        oos1.close();
        // 读取单例实例
        ObjectInputStream ois1=new ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingletonSerializable singletonSerializable = (InnerClassSingletonSerializable) ois1.readObject();
        ois1.close();
        // 对比序列化前后是否为同一实例
        System.out.println("(instanceSerializable == singletonSerializable) = " + (instanceSerializable == singletonSerializable));
    }
}
