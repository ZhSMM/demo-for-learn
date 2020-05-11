package org.example.structure.sort.exchange;

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
 * @description 快速排序
 *
 * 快速排序是对冒泡排序的一种改进。
 * 基本思想：
 *  通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据杜比另一部分的所有数据要小；
 *  然后再按此方法将这两部分数据分别进行快速排序，整个过程可以用递归来进行，以此达到整个数据编程有序数列。
 **/
public class QuickSortDemo {
    public static void quickSort(List<Integer> list,int left,int right){
        // 左右下标
        int l =left;
        int r = right;
        // 临时变量，交换时使用
        int tmp =0 ;
        int pivot = list.get(left);
//        // 中轴
//        int pivot=list.get((left+right)>>1);
//        // while循环的目的是，比pivot小的放到左边
//        // 比pivot大的放到右边
        while (l<r){
            // 在pivot的左边找到大于等于pivot的值
            while (list.get(l) < pivot){
                l++;
            }
            // 在pivot的右边找到小于等于pivot的值
            while (list.get(r)>pivot){
                r--;
            }
            // 如果了 l>= r ,说明pivot的左右两边的值，已经按照左边全部是小于等于pivot的值，
            // 右边全部是大于等于pivot的值
            if (l>=r){
                break;
            }
            tmp = list.get(l);
            list.set(l,list.get(r));
            list.set(r,tmp);
            // 如果交换完后，发现这个list.get(l) == pivot， 前移
            if (list.get(l) == pivot){
                l++;
            }
            if (list.get(r) == pivot){
                r--;
            }
        }

        // 如果 l == r，必须l++，r--，否则出现栈溢出
        if(l==r){
            l++;
            r--;
        }
        // 向左递归
        if (left<r){
            quickSort(list,left,r);
        }
        if (right>l){
            quickSort(list,l,right);
        }
    }

    public static void main(String[] args) {


        List<Integer> list = generateTwo();
        System.out.println("生成的数据:");
        print(list);

        System.out.println("快速排序测试：");
        quickSort(list,0,list.size()-1);
        InsertSortDemo.insertSortDemo(getList());
        print(list);
        print(getList());

        List<Integer> list1= GenerateRandomValues.generate();
        long start = System.currentTimeMillis();
        quickSort(list1,0,list1.size()-1);
        long end1=System.currentTimeMillis();
        System.out.println("快速排序 = " + (end1 - start));
    }
}
