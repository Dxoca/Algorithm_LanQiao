package org.lanqiao.algo.elementary._08_dp;

import org.lanqiao.algo.util.Util;

/**
 * c[i]是(i-lowbit(i),i]这个区间的累加和，不含i-lowbit(i)
 */
public class 树状数组 {
  public static void main(String[] args) {
    a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    n = a.length;
    c = new int[n + 1];
    for (int i = 0; i < n; i++) {
      update(i + 1, a[i]);
    }
    Util.print(c);
    System.out.println(sum(3));
    System.out.println(sum(4));
    System.out.println(sum(5));
    System.out.println(sum(6));
    System.out.println(sum(9));
    System.out.println(sum(10));
  }

  /**
   * 更新树状数组c，注意i是项数，不是下标，而是下标+1*/
  private static void update(int i, int v) {
    for (; i <= n; i += lowbit(i)) {
      c[i] += v;
    }
  }

  /**
   * 前i项和，注意：i不是下标
   * @param i
   * @return
   */
  private static int sum(int i) {
    int sum = 0;
    if (i > n)
      i = n;
    for (; i > 0; i -= lowbit(i)) {
      sum += c[i];
    }
    return sum;
  }

  static int[] a;
  static int[] c;
  static int n;

  /**
   * 它通过公式来得出k，其中k就是该值从末尾开始1的位置。
   * 然后将其得出的结果加上x自身就可以得出当前节点的父亲节点的位置
   * 或者是x减去其结果就可以得出上一个父亲节点的位置。
   * 比如当前是6，二进制就是0110，k为2，那么6+2=8，C(8)则是C(6)的父亲节点的位置；
   * 相反，6-2=4，则是C(6)的上一个父亲节点的位置。*/
  static int lowbit(int x) {
    return x - (x & (x - 1));
  }
}
