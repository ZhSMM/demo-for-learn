package org.example.demo.thread.cas;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description CAS测试
 **/

class User{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Demo {
    public static void main(String[] args) {
        // CAS
        AtomicInteger i=new AtomicInteger();
        i.incrementAndGet();

        // java对象布局
//        User user=new User();
//        System.out.println(ClassLayout.parseClass(User.class).toPrintable());
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());
//        user.setId(10);
//        user.setName("Hello");
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());

        // Synchronized 的原理
        Object o = new Object();
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
