package org.example.structure.sort.select;

import org.example.structure.sort.common.GenerateRandomValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.example.structure.sort.common.GenerateRandomValues.generateTwo;
import static org.example.structure.sort.exchange.BubbleSortDemo.print;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/03
 * @description 简单的选择排序
 **/
public class SimpleSelectSort {
    public static void simpleSelectSort(List<Integer> list){
        // 记录一趟扫描中的最小值下标
        int minIndex = 0;
        // 中间变量用于存值
        int min = list.get(minIndex);
        for (int i = 0; i < list.size()-1; i++) {
            minIndex = i;
            min = list.get(minIndex);
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j) < min){  // 说明假定的最小值不是最小值
                    min = list.get(j);  // 重置min
                    minIndex = j;   // 重置minIndex
                }
            }
            if (minIndex != i){
                list.set(minIndex,list.get(i));
                list.set(i,min);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = generateTwo();
        System.out.println("生成的数据:");
        print(list);

        System.out.println("选择排序测试：");
        simpleSelectSort(list);
        print(list);

        List<Integer> list1= GenerateRandomValues.generate();
        long start = System.currentTimeMillis();
        simpleSelectSort(list1);
        long end1=System.currentTimeMillis();
        System.out.println("选择排序 = " + (end1 - start));

        //第一次测试：
        //生成的数据:
        //-492147840	-1953729088	1580980608	1882861184	478048320	1967265728	74784512	69706816	-1128443840	1145068352	-1393288704	-1511686528	-1809365184	352258176	1409237696	450102848	-396925504	539698880	665699648	-1786164224	-16687552	2048261312	-653135360	-1377767936	411583232
        //选择排序测试：
        //-1953729088	-1809365184	-1786164224	-1511686528	-1393288704	-1377767936	-1128443840	-653135360	-492147840	-396925504	-16687552	69706816	74784512	352258176	411583232	450102848	478048320	539698880	665699648	1145068352	1409237696	1580980608	1882861184	1967265728	2048261312
        //选择排序 = 9176

        //第二次排序：
        //生成的数据:
        //-1821636992	-1565092864	-66617664	357670016	-633053632	1169185024	-611214784	-1742667456	1155608768	1576393344	-1869014016	-242920512	-1399636928	-1324403776	-264304704	923123328	504039232	-589779392	818269376	-592707264	799620992	1766529088	1572201408	2056004672	1996524480
        //选择排序测试：
        //-1869014016	-1821636992	-1742667456	-1565092864	-1399636928	-1324403776	-633053632	-611214784	-592707264	-589779392	-264304704	-242920512	-66617664	357670016	504039232	799620992	818269376	923123328	1155608768	1169185024	1572201408	1576393344	1766529088	1996524480	2056004672
        //选择排序 = 9160

        //第三次测试：
        //生成的数据:
        //-2120535104	-1451002240	-1205099008	-183363328	-396313984	-440597184	1536525568	-737923648	1788752448	1467546944	359278336	-1735824384	-734945728	-835082560	1992379264	-255090752	-864485824	1523378752	330499712	-1430122816	572392704	-290125952	-1556067200	-2079331968	1391119296
        //选择排序测试：
        //-2120535104	-2079331968	-1735824384	-1556067200	-1451002240	-1430122816	-1205099008	-864485824	-835082560	-737923648	-734945728	-440597184	-396313984	-290125952	-255090752	-183363328	330499712	359278336	572392704	1391119296	1467546944	1523378752	1536525568	1788752448	1992379264
        //选择排序 = 9060
    }
}
