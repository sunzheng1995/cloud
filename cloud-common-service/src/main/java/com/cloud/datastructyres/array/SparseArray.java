package com.cloud.datastructyres.array;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0：表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][5] = 2;
        System.out.println("---------------------------------------------------------原始二维数组：---------------------------------------------------------");
        printArr(chessArr1);
        // 将二维数组转化为稀疏数组
        // 1.先遍历二维数组获取非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组第一行赋值，代表原始数组大小
        sparseArr[0][0] = 11; // 行
        sparseArr[0][1] = 11;// 列
        sparseArr[0][2] = sum;// 有值元素的个数
        // 给稀疏数组放值
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("---------------------------------------------------------获得稀疏数组：---------------------------------------------------------");
        printArr(sparseArr);
        // 将稀疏数组恢复成原始二维数据
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("---------------------------------------------------------恢复二维数组：---------------------------------------------------------");
        printArr(chessArr2);
    }

    private static void printArr(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
