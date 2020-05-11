package org.example.demo.liskov;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description 里氏替换原则：所有父类出现的地方都可以用其子类替换
 * 要求：子类尽量不要重写父类的方法
 **/
public class Liskov {
    public static void main(String[] args) {
        // 测试
        B b=new B();
        System.out.println("b.fun1(10,9) = " + b.fun1(10, 9)); // 19,而不是父类的1
    }
}
// 父类
class A{
    public int fun1(int a,int b){
        return a-b;
    }
}

// 子类
class B extends A{
    @Override // fun1被重写
    public int fun1(int a, int b) {
        return a+b;
    }
    public int fun2(int a,int b){
        return fun1(a,b)+9;
    }
}