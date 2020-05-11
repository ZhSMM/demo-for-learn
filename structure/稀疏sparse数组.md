# 稀疏sparsearray数组

基本介绍：当一个数组中大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。

稀疏数组的处理方法：

1. 记录数组一共有几行几列，有多少个不同的值；
2. 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模；

示例：

1. 使用稀疏数组，来保存类似二维数组（棋盘、地图）等；
2. 把稀疏数组存盘，并且可以从新恢复为原来的二位数组；

稀疏数组结构：

- 稀疏数组总是有三列，用于存放： row |  col  |  val
- 第0行存放二维数组中的： 总共有多少行 |  总共多少列 | 共有多少个有效数据
- 从第一行开始存放数据： 第几行 | 第几列 | 值 

二维数组转换为稀疏数组：

1. 遍历原始数组，得到有效数据个数sum
2. 根据sum创建稀疏数组 `sparseArr int [sum+1][3];`
3. 将二维数组中的有效数据存入稀疏数组；

稀疏数组转原始数组：

1. 读取稀疏数组第一行，根据第一行数据创建原始二维数组；
2. 读取稀疏数组后几行的数组并赋值；

代码：

```java

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

```
