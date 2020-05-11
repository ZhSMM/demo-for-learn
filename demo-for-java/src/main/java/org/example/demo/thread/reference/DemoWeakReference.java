package org.example.demo.thread.reference;

import java.lang.ref.WeakReference;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 弱引用
 **/
public class DemoWeakReference {
    public static void main(String[] args) {
        /**
         * 弱引用：一旦发生垃圾回收，弱引用就会立即被回收
         */
        WeakReference<M> m =new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl=new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
