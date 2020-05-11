package org.example.structure.stock.poland;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/01
 * @description 逆波兰表达式的计算
 **/
public class PolandNotation {
    private static final int times = 2;
    private static final int divided = 2;
    private static final int sub = 1;  // -
    private static final int multi = 1;  // +

    public static int getPriority(char ch) {
        int res = 0;
        switch (ch) {
            case '+':
                res = multi;
                break;
            case '-':
                res = sub;
                break;
            case '*':
                res = times;
                break;
            case '/':
                res = divided;
                break;
            default:
                System.out.println("符号错误！");
                break;
        }
        return res;
    }

    // 将一个逆波兰表达式，依次将数据和运算符放入ArrayList
    public static List<String> getListString(String expression) {
        // 将expression分割
        String[] split = expression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculator(List<String> list) {
        // 逆波兰表达式： 为了方便，数值与符号使用空格隔开你，(3+4)*5-6如"3 4 + 5 * 6 -"
        // 1. 先将逆波兰表达式放入数组中 => 放到 ArrayList中
        // 2. 将ArrayList传递给一个方法，遍历ArrayList配合完成计算
//        List<String> list = getListString(expression);

        // 创建一个栈
        Stack<String> stack = new Stack<>();
        // 遍历 list
        for (String s : list) {
            // 使用正则表达式取出数
            if (s.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(s);
            } else {
                // pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符异常");
                }
                // 把res入栈
                stack.push("" + res);
            }
        }
        // 最后留在栈中的结果为运算结果
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀表达式转换为后缀表达式
     * 思路：
     * 1. 预处理，将字符串转换为字符串数组
     * 2. 创建一个符号栈和一个结果数组
     * 3.
     *
     * @param list 中缀表达式
     * @return 后缀表达式
     */
    public static List<String> convertReversePolishExpressionInfix(List<String> list) {
        // 结果数组:在整个转换过程中，没有pop操作，且需要逆序操作，因此使用数组比较方便
        ArrayList<String> res = new ArrayList<>();
        // 符号栈
        Stack<String> stack = new Stack<>();
        // 遍历指针
        int index = 0;
        // 存放取出的字符串
        String tmp = null;
        // 遍历数组，取出符号
        for (String s : list) {
            // 如果是一个数，加入符号栈
            if (s.matches("\\d+")){
                res.add(s);
            } else if ("(".equals(s)){  // 如果是左括号，放入符号栈
                stack.push(s);
            } else if (")".equals(s)){  // 如果是右括号，则依次弹出stack栈顶的运算符，直到遇到左括号为止，此时去掉这对括号
                while (!"(".equals(stack.peek())){  // 从符号栈弹出符号直到遇到左括号
                    res.add(stack.pop());
                }
                stack.pop(); // 将左边小括号弹出，消除小括号
            } else {
                // 当s的优先级小于等于stack栈顶运算符，将stack的栈顶运算符弹出并加入到s2中，再次与stack栈顶元素比较
                while (stack.size() != 0 && !"(".equals(stack.peek()) && getPriority(stack.peek().charAt(0))> getPriority(s.charAt(0))){
                    res.add(stack.pop());
                }
                // 还需要将s压入stack
                stack.push(s);
            }
        }
        // 将stack中剩余的运算符依次弹出并加入到res
        while (stack.size()!=0){
            res.add(stack.pop());
        }
        return res;
}

    // 预处理，字符串转换为字符串数组
    public static List<String> convertToListFromString(String expression) {
        List<String> list = new ArrayList<>();
        // 扫描索引
        int index = 0;
        // 扫描的字符
        char ch = ' ';
        // 拼接ch成数值
        StringBuilder builder = new StringBuilder();
        while (true) {
            ch = expression.charAt(index);
            // 如果ch是符号，则直接放入数组
            if (ch > 57 || ch < 48) {
                list.add("" + ch);
            } else { // 如果char是数字
                builder.append(ch);
                // 如果扫描到expression的尾部 或者 下一个字符为符号
                if (index == expression.length() - 1 || expression.charAt(index + 1) > 57 || expression.charAt(index + 1) < 48) {
                    // 如果下一个字符为符号,将builder转换为字符串，存入
                    list.add(builder.toString());
                    // 将builder置空
                    builder.delete(0, builder.length());
                }
            }
            index = index + 1;
            if (index == expression.length()) {  // 扫描到字符串结尾时，退出循环
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String expression = "3 4 + 51 * 66 -";
        System.out.println(calculator(getListString(expression)));
        String expression1 = "(3+4)*5-6";
        List<String> tmp=convertToListFromString(expression1);
        List<String> tmp1=convertReversePolishExpressionInfix(tmp);
        System.out.println(tmp);
        System.out.println(tmp1);
        System.out.println(calculator(tmp1));
    }
}
