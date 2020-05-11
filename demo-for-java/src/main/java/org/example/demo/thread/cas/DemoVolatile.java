package org.example.demo.thread.cas;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description volatile：保证线程之间的可见性
 **/
public class DemoVolatile {
    /** volatile */ boolean running = true;
    void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }
    public static void main(String[] args) {
        DemoVolatile demo=new DemoVolatile();
        new Thread(demo::m , "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demo.running = false;
    }
}
