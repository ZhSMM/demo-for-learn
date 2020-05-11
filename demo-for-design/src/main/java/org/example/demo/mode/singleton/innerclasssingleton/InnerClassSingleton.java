package org.example.demo.mode.singleton.innerclasssingleton;

import java.io.Serializable;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 内部类单例模式
 **/
public class InnerClassSingleton implements Serializable {

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        /**
         * 防止通过反射创建实例！
         */
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例不允许多个实例！");
        }
    }

    /**
     * 实现了一个懒加载单例模式，该单例在调用getInstance()方法时被实例化，
     * 即在调用getInstance时，JVM会加载该内部类完成实例化，利用JVM的类加载机制实现线程安全
     *
     * @return 单例
     */
    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }
}
