package org.example.demo.mode.singleton.lazysingleton;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 懒加载单例模式(非多线程安全版本)
 **/
public class LazySingleton {
    private static LazySingleton instance;

    // 避免LazySingleton通过空构造实例化
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            // 多线程测试，放大问题发生可能性！
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new LazySingleton();
        }
        return instance;
    }
}
