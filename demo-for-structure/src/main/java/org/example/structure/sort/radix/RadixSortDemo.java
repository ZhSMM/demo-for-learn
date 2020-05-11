package org.example.structure.sort.radix;

import org.example.structure.sort.common.GenerateRandomValues;
import org.example.structure.sort.insert.InsertSortDemo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

import static org.example.structure.sort.common.GenerateRandomValues.generateTwo;
import static org.example.structure.sort.common.GenerateRandomValues.getList;
import static org.example.structure.sort.exchange.BubbleSortDemo.print;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/04
 * @description 基数排序 radix sort
 * <p>
 * 基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，
 * 顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用，基数排序法是属于
 * 稳定性的排序，其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率
 * 高于其它的稳定性排序法。
 * <p>
 * 最高位优先(Most Significant Digit first)法，简称MSD法：
 * 先按k1排序分组，同一组中记录，关键码k1相等，再对各组按k2排序分成子组；
 * 之后，对后面的关键码继续这样的排序分组，直到按最次位关键码kd对各子组排序后；
 * 再将各组连接起来，便得到一个有序序列。
 * 最低位优先(Least Significant Digit first)法，简称LSD法：
 * 先从kd开始排序，再对kd-1进行排序，依次重复，直到对k1排序后便得到一个有序序列。
 **/
public class RadixSortDemo {
    public static void radixSort(int[] array) {
        // 计算数组最大值
        OptionalInt max = Arrays.stream(array).max();
        // 计算最大值有多少位
        int bits = 0;
        if (max.isPresent()) {
            int asInt = max.getAsInt();
            while (asInt > 0) {
                asInt /= 10;
                bits++;
            }
        }
        // 桶
        int[][] bucket = new int[10][array.length];
        // 每个桶的大小
        int[] depths = new int[10];
        // 中间变量
        int digitOfElement = 0;
        int index = 0;
        for (int i = 0, n = 1; i < bits; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                // 取出每个元素的值
                digitOfElement = array[j] / n % 10;
                // 放入对应的桶
                bucket[digitOfElement][depths[digitOfElement]]=array[j];
                // 对应的桶中元素含量加一
                depths[digitOfElement]++;
            }
            // 放入原数组下标
            index = 0;
            // 遍历每一桶，并将元素放入原数组
            for (int j = 0; j < 10; j++) {
                if (depths[j] != 0){
                    for (int k = 0; k < depths[j]; k++) {
                        // 取出元素放入原数组
                        array[index++] = bucket[j][k];
                    }
                }
                // 将桶中元素清零
                depths[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Random random=new Random();
        int[] array1= new int[25];
        for (int i = 0; i < 25; i++) {
            array1[i]=random.nextInt(100);
        }
        System.out.println("插入排序测试：");
        radixSort(array1);
        for (int i : array1) {
            System.out.print(i+"\t");
        }
        int[] array= new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i]=random.nextInt(800000);
        }
        long start = System.currentTimeMillis();
        radixSort(array);
        long end1=System.currentTimeMillis();
        System.out.println("插入排序 = " + (end1 - start));
    }
}