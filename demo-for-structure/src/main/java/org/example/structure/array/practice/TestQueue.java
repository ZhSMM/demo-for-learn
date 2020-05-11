package org.example.structure.array.practice;

import java.util.Scanner;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 队列测试
 **/
public class TestQueue {
    public static void main(String[] args) {
        DemoQueue<String> queue=new DemoCircleArrayQueue<>(10);
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
                    queue.print();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个字符串：");
                    String value = scanner.next();
                    if (queue.add(value)){
                        System.out.println("添加成功！");
                    }else{
                        System.out.println("添加失败！队列已满！");
                    }
                    break;
                case 'g':
                    System.out.println(queue.get());
                    break;
                case 'h':
                    System.out.println(queue.front());
                    break;
                default:
                    System.out.println("命令输入错误！");
            }
            System.out.println();
        }
    }
}
