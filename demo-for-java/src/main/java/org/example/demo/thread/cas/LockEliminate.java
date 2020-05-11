package org.example.demo.thread.cas;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 锁消除
 **/
public class LockEliminate {
    public void add(String str1,String str2){
        /**
         * StringBuffer 是线程安全的，因为其关键方法都是被synchronized修饰过的，
         * 但是在这段代码中，sb这个引用只会在add方法中使用，不可能被其他线程引用（局部变量，栈私有）
         * 因此，sb是不可能共享的资源，JVM会2自动消除StringBuffer对象内部的锁。
         */
        StringBuffer sb=new StringBuffer();
        sb.append(str1).append(str2);
    }
}
