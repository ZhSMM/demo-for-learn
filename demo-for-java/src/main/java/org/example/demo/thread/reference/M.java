package org.example.reference;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 测试类
 **/
public class M {
    /**
     * 垃圾回收时调用finalize
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
