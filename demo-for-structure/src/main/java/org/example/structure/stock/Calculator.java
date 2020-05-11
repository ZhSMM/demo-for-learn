package org.example.structure.stock;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/01
 * @description 通过传入的字符串表达式计算值，如"3+2-8*8-9+9"
 **/
public class Calculator {

    static class CalculatorStockDemo<T> extends StockDemo<T>{
        // 返回字符串的优先级:自定义 * / 为 1 ， + - 为 0
        public int priority(int oper){
            if (oper == '*' || oper == '/'){
                return 1;
            }else if (oper == '+' || oper == '-'){
                return 0;
            }else {
                return -1;
            }
        }
        // 判断是否为运算符 , &&  为短路
        public boolean isOper(char val){
            return val == '+' || val == '-' || val == '*' || val == '/';
        }
        // 计算
        public int cal(int num1,int num2,int oper){
            int res=0;  // 用于存放结果
            switch (oper){
                case '+':
                    res=num1+num2;
                    break;
                case '-':
                    res=num2-num1;
                    break;
                case '*':
                    res=num2*num1;
                    break;
                case '/':
                    res=num2/num1;
                    break;
                default:
                    break;
            }
            return res;
        }
    }

    public static int calculator(String expression){
        // 创建两个栈，数栈和符号栈
        CalculatorStockDemo<Integer> numStack=new CalculatorStockDemo<>();
        CalculatorStockDemo<Integer> operStack=new CalculatorStockDemo<>();
        // 定义相关的中间变量
        int num1=0;
        int num2=0;
        int res=0;
        int oper=0;
        int index=0;  // 用于扫描
        char ch=' ';  // 保存每次扫描到的char
        StringBuilder str=new StringBuilder(); // 用于拼接
        while (true){
            // 依次得到expression的每一个字符
            ch = expression.charAt(index);
            // 判断ch来做相应的处理
            if (operStack.isOper(ch)){  // 如果是运算符
                // 判断当前符号栈是否为空
                if (operStack.isEmpty()){
                    // 为空，直接入栈
                    operStack.push((int)ch);
                }else{
                    // 不为空，进行处理
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        // 把运算的结果入数栈
                        numStack.push(res);
                        // 然后把当前的操作符入符号栈
                        operStack.push((int)ch);
                    }else{
                        // 如果当前的操作符的优先级大于栈中的操作符，直接入符号栈
                        operStack.push((int)ch);
                    }
                }
            }else{
//                // 如果是数，直接入数栈
//                numStack.push((int)ch-48);  // '1'与整数1在ASCII中差了48
                // 1. 当处理一个数时，不能直接入栈
                // 2. 在处理数时，需要向expression的表达式index后面再看一位，如果是数就进行扫描，如果是符号才进行入栈
                // 3. 定义一个StringBuilder，用于拼接；
                str.append(ch);

                // 如果ch已经是expression的最后一位，就直接入栈
                // 判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                if (index==expression.length()-1 ||operStack.isOper(expression.charAt(index+1))){
                    // 如果下一位是运算符，则入栈
                    numStack.push(Integer.parseInt(str.toString()));
                    // 记得清空字符串构建
                    str.delete(0,str.length());
                }
            }
            // 让index+1，并判断是否扫描到expression最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        // 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true){
            // 如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            // 把运算的结果入数栈
            numStack.push(res);
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        String expression = "1+6*9-90/3";
        System.out.println(calculator(expression));
        System.out.println((int)'1');
    }
}
