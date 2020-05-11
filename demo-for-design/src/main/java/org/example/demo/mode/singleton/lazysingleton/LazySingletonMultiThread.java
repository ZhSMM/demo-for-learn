package org.example.demo.mode.singleton.lazysingleton;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/06
 * @description 多线程环境下的懒加载单例模式
 **/
public class LazySingletonMultiThread {
    // volatile修饰，防止指令重排序
    private volatile static LazySingletonMultiThread instance;

    // 避免LazySingleton通过空构造实例化
    private LazySingletonMultiThread() {
    }

    /**
     * 方案一：
     *   对getInstance加锁，就能够实现多线程环境下的单例模式
     *   缺点：每次访问都需要加锁，不管实例有没有被初始化，浪费资源和时间
     * @return
     */
//    public static synchronized LazySingletonMultiThread getInstance(){
//        if (instance == null){
//            instance=new LazySingletonMultiThread();
//        }
//        return instance;
//    }

    /**
     * 方案二：
     * 先判断instance是否为空，如果不为空，则不需要加锁，仅对实例化过程进行加锁；
     *
     * @return
     */
    public static LazySingletonMultiThread getInstance() {
        if (instance == null) {
            /**
             * 可能同时存在多个线程进入synchronized代码块，使得实例化多次，
             * 因此需要在synchronized内部对instance进行判断，避免多次实例化
             */
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingletonMultiThread();
                    /**
                     * 字节码层面：
                     * 可能发生指令重排：
                     *   JIT：Just In Time 即时编译
                     *   CPU
                     *  1. 分配空间
                     *  2. 初始化
                     *  3. 引用赋值
                     *
                     *  存在的问题：可能由于指令重排，导致引用赋值和初始化顺序颠倒，
                     *  而下一个过来的线程由于引用已经赋值，直接返回，存在获取到空指针的现象.
                     *
                     *  因此，需要volatile来修饰实例，避免指令重排。
                     */
                }
            }
        }
        return instance;
    }
}
