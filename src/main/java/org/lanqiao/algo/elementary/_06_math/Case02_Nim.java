package org.lanqiao.algo.elementary._06_math;

/**
 * 几个数字做模2的加法，如果为0，无论怎么拿结果都不为0 ，如果不为0 ，总有办法改变一个数字把它变成0
 *  11
 * 100
 * 101
 * ----
 * 010
 * 现在不为0，我们改变第二位就可以将结果变为0
 */
public class Case02_Nim {
  public static void main(String[] args) {
    int[] A = {5, 10, 15};
    boolean res = solve(A);
    System.out.println(res);
  }

  static boolean solve(int[] A) {
    int res = 0;
    for (int i = 0; i < A.length; i++) {
      res ^= A[i];
      // System.out.println(Integer.toBinaryString(A[i]));
    }
    return res != 0;
  }

}
