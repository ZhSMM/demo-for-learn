package org.example.demo.thread.reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 软引用
 **/
public class DemoSoftReference {
    public static void main(String[] args) {
        // 软引用
        SoftReference<byte[]> m=new SoftReference<>(new byte[1024*1024*10]);
        // m=null
        System.out.println(m.get());
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        // 再次分配一个数组，heap将装不下，系统会发起垃圾回收，先回收一次，如果不够，
        // 会把软引用干掉
        byte[] b=new byte[1024*1024*10];
        System.out.println(m.get());

        // 软引用适合缓存使用
        ThreadLocal<M> local=new ThreadLocal<>();
        local.set(new M());
        local.remove();
    }
}
