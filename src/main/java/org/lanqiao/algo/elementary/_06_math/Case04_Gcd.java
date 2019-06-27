package org.lanqiao.algo.elementary._06_math;

public class Case04_Gcd {
  /**
   * 欧几里德算法算法,即辗转相除法
   * @param m
   * @param n
   * @return
   */
  public static long gcd(long m, long n) {
    return n == 0 ? m : gcd(n, m % n);
  }

  /**
   * 最小公倍数lowest common multiple (LCM)
   * @param a
   * @param b
   * @return
   */
  private static long lcm(long a, long b) {
    return a * b / gcd(a, b);
  }
}
