package org.example.structure.recursion;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/02
 * @description 8皇后问题的回溯算法
 **/
public class EightQueue {
    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后位置的数组
    int[] array = new int[max];
    // 定义一个计数变量
    public static int count = 0;
    // 执行判断的次数
    public static int judge = 0;

    public static void main(String[] args) {
        // 测试
        EightQueue eightQueue = new EightQueue();
        eightQueue.check(0);
        System.out.println("count = " + count);
        System.out.println("judge = " + judge);
    }

    // 输出皇后的位置
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    // 放置第n个皇后
    // check每一次递归时，进入check中都会有for（int i=0;i<max;i++),因此会有回溯
    private void check(int n) {
        if (n == max) {
            // n=8,说明8个皇后已经放好
            print();
            return;
        }
        // 依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前皇后 n ，放在该行的第一列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                // 接着放 n+1个皇后，即开始递归
                check(n + 1);
            }
            // 如果冲突，就继续执行 array[n] = i; 即将第n个皇后放置在本行的后移一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后时，查看第n个皇后是否冲突
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judge++;
        for (int i = 0; i < n; i++) {
            // 1. array[i] == array[n] 表示判断第n个皇后是否和前面的皇后在同一列
            // 2. Math.abs(n-i) == Math.abs(array[n]-array[i]) 表示判断第n个皇后与第i个皇后是否在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
