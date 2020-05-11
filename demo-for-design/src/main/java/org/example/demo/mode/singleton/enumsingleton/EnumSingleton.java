package org.example.demo.mode.singleton.enumsingleton;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 利用枚举类型创建单例模式
 **/
public enum EnumSingleton {
    INSTANCE;

    public void print() {
        System.out.println("this.hashCode() = " + this.hashCode());
    }
}
