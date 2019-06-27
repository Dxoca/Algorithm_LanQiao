package org.lanqiao.algo.elementary._04matrix;

import java.util.Arrays;

/**
 * 假定只有一行，那就和求最大和子数组一样
 * 如果限定两行，可以把两行按列求和，同上
 * ……
 * 所有我们从把第一行当做起点，依次累加后面的每一行后，都求一个最大子数组和
 * 以第二行作为起点，依次累加后面的每一行后，都求一个最大子数组和
 *
 * 每次求出来的和与历史最大值比较，如果更大，则更新
 */
public class Case06_MaxSubMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        {-90, 48, 78},
        {64, -40, 64},
        {-81, -7, 66}
    };
    matrix = new int[][]{{1, 2, -1}};
    int res = maxSum(matrix);
    System.out.println(res);
  }

  //N^3时间复杂度
  private static int maxSum(int[][] matrix) {
    int beginRow = 0;//以它为起始行

    final int M = matrix.length;
    final int N = matrix[0].length;

    int[] sums = new int[N];//按列求和

    int max = 0;//历史最大的子矩阵和

    while (beginRow < M) {//起始行
      for (int i = beginRow; i < M; i++) {//从起始行到第i行
        //按列累加
        for (int j = 0; j < N; j++) {
          sums[j] += matrix[i][j];
        }
        //  累加完成
        //  求出sums的最大和子数组O(n)
        int t = Case05_MaxSubArray.findByDp(sums);
        if (t > max)
          max = t;
      }
      //另起一行作为起始行.把sums清零
      Arrays.fill(sums, 0);//快速地将sums的每个元素都设定为0
      beginRow++;
    }
    return max;
  }
}
