package org.example.structure.sort.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/03
 * @description 生成80000个随机数的数组
 **/
public class GenerateRandomValues {
    private static final Random RANDOM=new Random();
    public static List<Integer> list=new ArrayList<>(25);

    public static List<Integer> generate(){
        List<Integer> list = new ArrayList<>(80000);
        for (int i = 0; i < 80000; i++) {
            list.add(RANDOM.nextInt(100000));
        }
        return list;
    }
    public static List<Integer> generateTwo(){
        List<Integer> listNew = new ArrayList<>(25);
        int tmp=0;
        for (int i = 0; i < 25; i++) {
            tmp=RANDOM.nextInt(100);
            list.add(tmp);
            listNew.add(tmp);
        }
        return listNew;
    }
    public static void print(List<Integer> list){
        list.forEach(integer -> {
            System.out.print(integer + "\t");
        });
        System.out.println();
    }
    public static List<Integer> getList(){
        return list;
    }
}
