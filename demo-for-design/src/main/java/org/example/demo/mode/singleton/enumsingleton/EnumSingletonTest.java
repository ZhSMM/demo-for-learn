package org.example.demo.mode.singleton.enumsingleton;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description details
 **/
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance=EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;

        System.out.println(instance ==instance1);
    }
}
