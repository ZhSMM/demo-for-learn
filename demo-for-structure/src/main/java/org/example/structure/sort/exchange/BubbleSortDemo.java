package org.example.structure.sort.exchange;

import org.example.structure.sort.common.GenerateRandomValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.structure.sort.common.GenerateRandomValues.*;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/02
 * @description Bubble Sort:冒泡排序
 *
 * 总结：
 *  1. 一共进行数组的大小 -1次大的循环；
 *  2. 每一趟排序的次数逐渐减小；
 *  3. 如果某次排序未发生交换，结束排序；
 **/

public class BubbleSortDemo {
    /**
     * 冒泡排序：
     * 最原始的版本，直接交换list.size()次数
     * @param list 待排序的数组
     */
    public static void bubbleSortOrigin(List<Integer> list){
        // 临时变量
        int tmp=0;
        // 循环计数
        int count = list.size();
        while (count>0) {
            --count;
            for (int i = 0; i < count; i++) {
                // 如果前面的数大于后面的数
                if (list.get(i) > list.get(i + 1)) {
                    tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                }
            }
        }
    }
    // 当不存在交换时，说明已经排好了序，直接跳出循环
    public static void bubbleSortTwo(List<Integer> list){
        // 标识此次是否有进行交换，有交换为true
        boolean flag = false;
        // 计数变量
        int count = list.size();
        // 中间变量
        int tmp=0;
        while (count>0){
            count -- ;
            flag = false;
            for (int i = 0; i < count; i++) {
                // 如果前面的数大于后面的数
                if (list.get(i) > list.get(i + 1)) {
                    tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                    flag = true;
                }
            }
            if (!flag){  // 不存在交换，说明排好了序，跳出循环
                break;
            }
        }
    }
    // 优化：记录上一次交换的最后一位，后面的明显已经排好序了
    public static void bubbleSortThree(List<Integer> list){
        // 记录最后一次发生交换的位置
        int index = list.size()-1;
        int size=list.size()-1;
        // 记录中间值
        int tmp = 0;
        while (index>0){
            index = 0;
            for (int i = 0; i < size; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                    index = i;
                }
            }
            size = index;
        }
    }
    // 输出数组
    public static void print(List<Integer> list){
        list.stream().forEach((integer)->{
            System.out.print(integer+"\t");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = generateTwo();
        System.out.println("生成的数据:");
        print(list);

        System.out.println("原始版本测试：");
        bubbleSortOrigin(list);
        print(list);

        list = generateTwo();
        System.out.println("优化一版本测试:");
        bubbleSortTwo(list);
        print(list);

        list = generateTwo();
        System.out.println("优化二版本测试:");
        bubbleSortThree(list);
        print(list);

        // 80000条数据测试
        List<Integer> list1= GenerateRandomValues.generate();
        List<Integer> list2= GenerateRandomValues.generate();
        List<Integer> list3= GenerateRandomValues.generate();

        long start = System.currentTimeMillis();
        bubbleSortOrigin(list1);
        long end1=System.currentTimeMillis();
        System.out.println("原始版本 = " + (end1 - start));
        bubbleSortTwo(list2);
        long end2=System.currentTimeMillis();
        System.out.println("一改版本 = " + (end2 - end1));
        bubbleSortThree(list3);
        long end3=System.currentTimeMillis();
        System.out.println("二改版本 = " + (end3 - end2));
    }
}
