package org.example.structure.array;

import java.util.Scanner;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 使用数组模拟队列
 **/

class ArrayQueue {
    // 最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 存放数据
    private int[] arr;

    // 创建队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部的前一个位置
        rear = -1;  // 指向队列尾部
    }

    // 判断队列是否是满的
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    // 添加数据到队列
    public boolean put(int n){
        // 判断队列是否已满
        if (this.isFull()){
            System.out.println("数据已满");
            return false;
        }
        rear++;
        arr[rear]=n;
        return true;
    }
    // 获取数据
    public int push(){
        // 判断队列是否为空
        if (this.isEmpty()){
            // 通过抛出异常处理
            throw new RuntimeException("队列为空，无法获取数据");
        }
        ++front;
        return arr[front];
    }
    // 遍历
    public void show(){
        if (isEmpty()){
            System.out.println("队列为空！");
            throw new RuntimeException("队列为空");
        }
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }
    // 显示队列头数据
    public int top(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front+1];
    }
}

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key=' ';

        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):显示队列头部数据");

            key = scanner.next().charAt(0);  // 接受一个字符
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.put(value);
                    break;
                case 'g':
                    System.out.println(queue.push());
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
