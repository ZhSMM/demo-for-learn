package org.example.structure.array.practice;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 环形数组实现
 **/
public class DemoCircleArrayQueue<T> implements DemoQueue<T> {
    // 最大容量
    private int maxSize;
    // 队列头:front指向队列的第一个元素，front的初始值：front = 0；
    private int front;
    // 队列尾:rear指向队列的最后一个元素的后一个位置，希望空出一个空间作约定，rear的初始值：rear=0；
    private int rear;
    // 存放数据
    private T[] queue;

    public DemoCircleArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        this.queue = this.newArray(this.maxSize);
        rear = 0;
        front = 0;
    }

    // 创建泛型数组时，无法直接创建，只能先创建Object数组，再强转
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public T get() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空！");
        }
        // 中间变量：保存获得的元素值
        T t = queue[front];
        // 将front向后移动一位,必须取模
        front = (front + 1) % maxSize;
        return t;
    }

    @Override
    public boolean add(T t) {
        if (isFull()){
            return false;
        }
        // 新增一位
        queue[rear]=t;
        // 将rear向后移动一位，必须取模
        rear = (rear+1)%maxSize;
        return true;
    }

    @Override
    public T front() {
        return queue[front];
    }

    @Override
    public void print() {
        for (int i = front; i < front+size(); i++) {
            System.out.println("queue["+i%maxSize+"]="+queue[i%maxSize]);
        }
    }
    // 获得有效元素数量
    private int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
