package org.example.structure.sort.merge;

import org.example.structure.sort.common.GenerateRandomValues;
import org.example.structure.sort.insert.InsertSortDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.structure.sort.common.GenerateRandomValues.generateTwo;
import static org.example.structure.sort.common.GenerateRandomValues.getList;
import static org.example.structure.sort.exchange.BubbleSortDemo.print;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/03
 * @description 归并排序
 * <p>
 * 归并排序：
 * 采用了分支思想：先分再和
 **/
public class MergeSortDemo {
    // 分的方法
    public static void mergeSort(List<Integer> list, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) >> 1;  // 中间索引
            // 向左递归分解
            mergeSort(list, left, mid, tmp);
            // 向右递归分解
            mergeSort(list, mid + 1, right, tmp);

            // 合并
            merge(list, left, mid, right, tmp);
        }
    }

    /**
     * 合并过程
     *
     * @param list  排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param tmp   中转数组
     */
    public static void merge(List<Integer> list, int left, int mid, int right, int[] tmp) {
        // 初始有序序列的初始索引
        int l = left;  // 左边
        int m = mid + 1;  // 右边
        // 指向tmp数组的当前索引
        int t = 0;

        // 先把左右两边（有序）的数组按照规则填充到tmp数组
        // 直到左右两边的有序序列，有一边处理完毕为止
        while (l <= mid && m <= right) {
            if (list.get(l) < list.get(m)) {
                tmp[t++] = list.get(l++);
            } else {
                tmp[t++] = list.get(m++);
            }
        }
        // 将剩余的一方的值填充进去
        while (l <= mid) {  // 左边有剩余
            tmp[t++] = list.get(l++);
        }
        while (m <= right) {
            tmp[t++] = list.get(m++);
        }
        // 将tmp数组拷贝回list数组
        // 注意不是都拷贝所有
        t = 0;
        int tmpLeft = left;
        while (tmpLeft <= right) {
            list.set(tmpLeft++, tmp[t++]);
        }
    }

    public static void main(String[] args) {
        // 归并排序需要一个额外的空间
        int[] tmp = new int[82000];
        List<Integer> list = generateTwo();
        System.out.println("生成的数据:");
        print(list);

        System.out.println("插入排序测试：");
        mergeSort(list, 0, list.size() - 1, tmp);
        InsertSortDemo.insertSortDemo(getList());
        print(list);
        print(getList());

        List<Integer> list1= GenerateRandomValues.generate();
        long start = System.currentTimeMillis();
        mergeSort(list1,0,list1.size()-1,tmp);
        long end1=System.currentTimeMillis();
        System.out.println("归并排序 = " + (end1 - start));
    }
}
