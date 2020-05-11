package org.example.structure.array;

import java.util.Scanner;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 环形队列
 **/

class CircleArrayQueue {
    // 最大容量
    private int maxSize;
    // 队列头:front指向队列的第一个元素，front的初始值：front = 0；
    private int front;
    // 队列尾:rear指向队列的最后一个元素的后一个位置，希望空出一个空间作约定，rear的初始值：rear=0；
    private int rear;
    // 存放数据
    private int[] arr;

    // 创建队列
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    // 判断队列是否是满的
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public boolean put(int n) {
        // 判断队列是否已满
        if (this.isFull()) {
            System.out.println("数据已满");
            return false;
        }
        // 直接添加数据
        arr[rear] = n;
        // 将rear后移，必须取模
        rear = (rear + 1) % maxSize;
        return true;
    }

    // 获取数据
    public int get() {
        // 判断队列是否为空
        if (this.isEmpty()) {
            // 通过抛出异常处理
            throw new RuntimeException("队列为空，无法获取数据");
        }
        // 这里需要分析出front是指向队列的第一个元素
        // 1. 这里需要先把front对应的值保留到一个临时变量
        // 2. 将front后移
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 遍历
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空！");
            throw new RuntimeException("队列为空");
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d \n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列头数据
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front];
    }
}

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个环行队列，设置4，说明其队列的最大有效数据是3
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' ';  // 接受用户输入

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):显示队列头部数据");

            key = scanner.next().charAt(0);  // 接受一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.put(value);
                    break;
                case 'g':
                    System.out.println(queue.get());
                    break;
                case 'h':
                    System.out.println(queue.top());
                    break;
                default:
                    System.out.println("命令输入错误！");
            }
            System.out.println();
        }
    }
}
