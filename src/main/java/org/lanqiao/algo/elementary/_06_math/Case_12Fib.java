package org.lanqiao.algo.elementary._06_math;

import org.lanqiao.algo.util.Util;

public class Case_12Fib {
  public static void main(String[] args) {
    for (int i = 1; i < 10; i++) {
      System.out.println(fib(i));
    }
  }

  /**
   * 矩阵运算求解斐波那契
   * @param n
   * @return
   */
  public static long fib(long n) {
    if (n == 1 || n == 2) return 1;
    long[][] matrix = {
        {0, 1},
        {1, 1}};
    long[][] res = Util.matrixPower(matrix, n - 1);//乘方
    res = Util.matrixMultiply(new long[][]{{1, 1}}, res);//矩阵相乘
    return res[0][0];
  }
}
