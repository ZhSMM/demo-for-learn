package org.example.structure.stock;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/01
 * @description 栈的实现
 **/

public class StockDemo<T> {
    private int maxSize;   // 栈容量
    private T[] values;  // 栈的值
    private int top;   // 栈的顶端指针

    public StockDemo() {
        this.maxSize = 10;
        this.values = getValues();
        this.top = -1;
    }

    // 初始化栈
    public StockDemo(int maxSize) {
        this.maxSize = maxSize;
        this.values = getValues();
        this.top = -1;
    }
    private T[] getValues(){
        return (T[])new Object[maxSize];
    }

    // 判断栈满
    public boolean isFull(){
        return top == maxSize -1;
    }
    // 判断栈空
    public boolean isEmpty(){
        return top == -1;
    }
    // 入栈
    public void push(T value){
        if (isFull()){
            System.out.println("栈已满，入栈失败！");
            return;
        }
        values[++top]=value;
    }
    // 出栈
    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空！");
        }
        return values[top--];
    }
    // 遍历栈
    public void print(){
        if (isEmpty()){
            return;
        }
        for (int i = top; i>=0 ; i--) {
            System.out.println(values[i]);
        }
    }
    // 返回栈顶的值
    public T peek(){
        return values[top];
    }

    public static void main(String[] args) {
        StockDemo<String> stringStockDemo = new StockDemo<>();
        // 判断是否为空
        System.out.println(stringStockDemo.isEmpty());
        // push
        for (int i = 0; i < 15; i++) {
            stringStockDemo.push("hello:"+i);
        }
        // 遍历
        stringStockDemo.print();
        // 出栈
        for (int i = 0; i < 11; i++) {
            System.out.println(stringStockDemo.pop());
        }
    }
}
