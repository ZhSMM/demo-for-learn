package org.example.demo.principle.liskov.improve;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description 实现里氏替换原则的方式：提供一个更加基础的基类，使用组合方式
 **/
public class Liskov {
    public static void main(String[] args) {
        // 测试
        B b=new B();
        // 调用完成的功能更明确
        System.out.println("b.fun1(10,9) = " + b.fun1(10, 9));
    }
}
// 创建一个更加基础的基类
class Base{
    // 把更加基础的方法和成员写到Base类
}

// A类
class A extends Base{
    public int fun1(int a,int b){
        return a-b;
    }
}

// B类
// 实现一个新功能：完成两个数相加，然后和9求和
class B extends Base {
    // 如果B需要使用A类的方法，使用组合关系
    private A a=new A();

    public int fun1(int a, int b) {
        return a+b;
    }

    public int fun2(int a,int b){
        return this.a.fun1(a,b)+9;
    }
}