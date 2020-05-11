package org.example.demo.mode.singleton.lazysingleton;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 懒加载单例模式测试
 **/
public class LazySingletonTest {
    public static void main(String[] args) {
        // 单线程测试
//        LazySingleton lazySingleton=LazySingleton.getInstance();
//        LazySingleton lazySingleton1=LazySingleton.getInstance();
//
//        System.out.println(lazySingleton == lazySingleton1);

        // 多线程环境
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}
