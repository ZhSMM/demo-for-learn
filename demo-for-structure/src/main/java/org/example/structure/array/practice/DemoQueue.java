package org.example.structure.array.practice;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 队列接口
 **/
public interface DemoQueue<T> {
    // 判断队列是否已满
    boolean isFull();
    // 判断队列是否为空
    boolean isEmpty();
    // 获取数据
    T get();
    // 添加数据
    boolean add(T t);
    // 得到队列前面的数据
    T front();
    // 遍历输出
    void print();
}
