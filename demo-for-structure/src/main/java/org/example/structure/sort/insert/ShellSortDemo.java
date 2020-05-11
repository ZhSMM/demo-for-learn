package org.example.structure.sort.insert;

import org.example.structure.sort.common.GenerateRandomValues;

import java.util.Arrays;
import java.util.List;

import static org.example.structure.sort.common.GenerateRandomValues.generateTwo;
import static org.example.structure.sort.common.GenerateRandomValues.getList;
import static org.example.structure.sort.exchange.BubbleSortDemo.print;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/03
 * @description 希尔排序
 **/
public class ShellSortDemo {
    // 希尔排序时，对有序序列在插入时采取交换法和移动法；
    public static void shellSortExchange(List<Integer> list) {
        // 定义交换用的中间变量
        int tmp = 0;
        // 从步长为list.size()一半进行分组，然后进行排序
        for (int gap = list.size()>>1; gap > 0; gap >>= 1) {
            for (int i = gap; i < list.size(); i++) {
                for (int j = i-gap; j >=0 ; j -=gap) {
                    if (list.get(j)>list.get(j+gap)){
                        // 如果当前元素大于步长后那个元素，则进行交换
                        tmp=list.get(j+gap);
                        list.set(j+gap,list.get(j));
                        list.set(j,tmp);
                    }
                }
            }
        }
    }
    // 采用移位法
    public static void shellSort(List<Integer> list) {
        // 定义交换用的中间变量
        int tmp = 0;
        // 定义用于存储下标的变量
        int index =0;
        // 从步长为list.size()一半进行分组，然后进行排序
        for (int gap = list.size()>>1; gap > 0; gap >>= 1) {
            // 从第gap个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < list.size(); i++) {
                index=i;
                tmp=list.get(index);
                if (list.get(index) < list.get(index-gap)){
                    while (index - gap >=0 && tmp<list.get(index-gap)){
                        // 移动
                        list.set(index,list.get(index-gap));
                        index -= gap;
                    }
                    // 当退出while后，就给tmp找到插入的位置
                    list.set(index,tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = generateTwo();
        System.out.println("生成的数据:");
        print(list);

        System.out.println("插入排序测试：");
        shellSort(list);
        InsertSortDemo.insertSortDemo(getList());
        print(list);
        print(getList());

        List<Integer> list1= GenerateRandomValues.generate();
        long start = System.currentTimeMillis();
        shellSort(list1);
        long end1=System.currentTimeMillis();
        System.out.println("插入排序 = " + (end1 - start));
    }
}
