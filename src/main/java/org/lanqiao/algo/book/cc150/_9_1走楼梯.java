package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.util.Util;

/**
 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 请实现一个方法，计算小孩有多少种上楼的方式。
 为了防止溢出，请将结果Mod 1000000007

 给定一个正整数int n，请返回一个数，代表上楼的方式数。
 保证n小于等于100000。
 */
public class _9_1走楼梯 {
  static final int mod = 1000000007;

  public static void main(String[] args) {
    System.out.println(recursion2(7));
    System.out.println(recursion1(7));
    System.out.println(recursion3(7));
  }

  /**
   * n较小的时候就会超时
   * @param n
   * @return
   */
  public static long recursion1(int n) {
    if (n < 0) return 0;
    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;
    return recursion1(n - 1) % mod + recursion1(n - 2) % mod + recursion1(n - 3) % mod;
  }

  // 1 2 4 7 13 24 44
  public static int recursion2(int n) {
    if (n < 0) return 0;
    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 4;
    int x1 = 1;
    int x2 = 2;
    int x3 = 4;
    for (int i = 4; i <= n; i++) {
      int x_1 = x1;
      x1 = x2 % mod;
      x2 = x3 % mod;
      x3 = ((x1 + x2) % mod + x_1) % mod;//注意此处
    }
    return x3;
  }

  public static int recursion3(int n) {
    long[][] base = {
        {0, 0, 1},
        {1, 0, 1},
        {0, 1, 1}};
    long[][] f1f2f3 = {{1, 2, 4}};
    return (int) Util.matrixMultiply(f1f2f3, Util.matrixPower(base, n - 1))[0][0];
  }
}
