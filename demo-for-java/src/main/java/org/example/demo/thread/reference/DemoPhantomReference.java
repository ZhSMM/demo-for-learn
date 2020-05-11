package org.example.demo.thread.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 虚引用
 **/
public class DemoPhantomReference {
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();
    private static final List<Object> LIST = new LinkedList<>();
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        /**
         * 虚引用作用：当对象被回收时，通过Queue可以检测到，然后清理堆外内存。
         *   管理堆外内存。
         *
         * 在NIO中的DirectByteBuffer中可以使用到
         *
         */
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[MB]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("---虚引用对象被jvm回收了 ---" + poll);
                }
            }
        }).start();

    }
}
