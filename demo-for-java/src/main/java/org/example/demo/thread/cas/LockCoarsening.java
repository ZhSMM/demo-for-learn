package org.example.demo.thread.cas;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 锁粗化
 **/
public class LockCoarsening {
    public String test(String str){
        int i =0 ;
        StringBuffer sb = new StringBuffer();
        /**
         * JVM 会检测到这样一连串的操作都对同一个对象加锁，while循环内100次append，没有锁粗化
         * 就要进行100次加锁/解锁，此时JVM就会将加锁的范围粗化到这一连串的操作的外部（比如while虚幻体外），
         * 使得这一连串加索只需要加锁一次即可。
         */
        while (i<100){
            sb.append(str);
            i++;
        }
        return sb.toString();
    }
}
