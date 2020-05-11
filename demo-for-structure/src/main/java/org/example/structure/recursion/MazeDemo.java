package org.example.structure.recursion;

import com.sun.istack.internal.NotNull;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/02
 * @description maze:迷宫(recursion)问题，递归的应用之一
 **/
public class MazeDemo {
    public static void main(String[] args) {
        // 1. 先创建二维数组，模拟迷宫maze地图
        int[][] map = new int[8][7];
        // 2. 约定：1 表示墙，0为通道
        // 将第一行和第8行置为一
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 将第一列和第7列置为一
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 输出地图情况
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        // 设置短板
        map[3][1]=1;
        map[3][2]=1;

        // 使用递归回溯找路
        System.out.println(setWay(map, 1, 1));
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 1. map表示地图
     * 2. i，j为出发点的横纵坐标（1，1）
     * 3. 如果小球找到[6][5]位置，说明找到通路
     * 4. 约定：当map[i][j]为0时，表明该点没有做过，为1表示墙，为2表示通路可以走，3表示该点走过，但未通
     * 5. 在走迷宫，需要策略（方法： 下 -> 右 -> 上-> 左），如果该点走不通，就回溯；
     * @param map 地图
     * @param i 从哪个位置触发
     * @param j 从哪个位置触发
     * @return 是否找到通路，找到返回true，否则false
     */
    public static boolean setWay(@NotNull int[][] map, int i, int j){
        if (map[6][5] == 2){
            // 通路找到
            return true;
        }else{
            if (map[i][j]==0){ // 表明当前节点未走过
                // 按照策略：下 -> 右 -> 上-> 左 进行移动
                map[i][j] = 2; // 假定该点可以走通
                if (setWay(map,i+1,j)){  // 向下走
                    return true;
                }else if (setWay(map,i,j+1)){ // 向右走
                    return true;
                }else if (setWay(map,i-1,j)){ // 向上走
                    return true;
                }else if (setWay(map,i,j-1)){ // 向左走
                    return true;
                } else {
                    // 说明该点走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            } else { // map[i][j] !=0 ,可能是1，2，3
                return false;
            }
        }
    }
}
