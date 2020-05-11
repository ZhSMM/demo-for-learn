package org.example.demo.mode.singleton.hungrysingleton;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 饿汉 -- 单例模式
 **/
public class HungrySingleton {
    // 在类加载最后一步初始化阶段被实例化
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        if (instance!=null){
            throw new RuntimeException("单例不允许存在多个实例！");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance == instance2);
    }
}
