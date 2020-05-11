package org.example.structure.array;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 稀疏数组转换
 **/
public class SparseArray {

    public static void main(String[] args) {
        // 1. 创建二维原始数组  0 表示无子 ，1表示白子 ，2表示黑子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[3][2] = 2;

        // 2.输出原始二维数组
        System.out.println("原始二维数组：");
        print(chessArr);

        // 3.转换后的稀疏数组
        int[][] sparse=ConvertToSparseArray(chessArr);
        print(sparse);

        // 4.重新转换为原始数组
        int[][] to=ConvertFromSparseToOrigin(sparse);
        print(to);
    }
    // Sparse数组转换为二维数组
    public static int[][] ConvertFromSparseToOrigin(int[][] sparse){
        int[][] result=new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            result[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        return result;
    }

    // 将二维原始数组转换为稀疏Sparse数组
    public static int[][] ConvertToSparseArray(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                }
            }
        }
        // 创建稀疏数组
        int[][] result = new int[count + 1][3];
        // 给稀疏数组赋值
        result[0][0] = array.length;
        result[0][1] = array[0].length;
        result[0][2] = count;

        int tmp = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    result[tmp][0] = i;
                    result[tmp][1] = j;
                    result[tmp++][2] = array[i][j];
                }
                if (tmp == count+1 ){
                    break;
                }
            }
        }
        return result;
    }

    // 二维数组遍历
    public static void print(int[][] array) {
        for (int[] row : array) {
            for (int item : row) {
                System.out.print(item + "\t");
            }
            System.out.print("\n");
        }
    }
}
