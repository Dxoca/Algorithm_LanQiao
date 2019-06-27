package org.lanqiao.algo.elementary._02_01_recursion;

import org.lanqiao.algo.util.Util;

public class _00_什么是递归 {

  //注意死循环
  static void f(int i) {
    if (i == 0)
      return;
    //调用自身
    f(i - 1);
  }

  /**
   * f1(n):求n的阶乘-->f1(n-1)求n-1的阶乘
   * 找重复：n*(n-1)的阶乘,求n-1的阶乘是原问题的重复（规模更小）——子问题
   * 找变化：变化的量应该作为参数
   * 找边界：出口*/
  static int f1(int n) {
    if (n == 1)
      return 1;
    return n * f1(n - 1);
  }

  /**
   * 打印i到j
   * 找重复：
   * 找变化：变化的量应该作为参数
   * 找边界：出口*/
  static void f2(int i, int j) {
    if (i > j)
      return;
    System.out.println(i);
    f2(i + 1, j);
  }

  /**
   * 对arr的所有元素求和
   * 找重复：
   * 找变化：变化的量应该作为参数
   * 找边界：出口
   * @param arr
   */
  static int f3(int[] arr, int begin) {
    if (begin == arr.length - 1) {
      return arr[begin];
    }
    return arr[begin] + f3(arr, begin + 1);
  }

  /**
   * 翻转字符串
   * @param src
   * @param end
   * @return
   */
  static String reverse(String src, int end) {
    if (end == 0) {
      return "" + src.charAt(0);
    }
    return src.charAt(end) + reverse(src, end - 1);
  }

  /**
   * O(2^n)
   * @param n
   * @return
   */
  static int fib(int n) {
    if (n == 1 || n == 2)
      return 1;
    return fib(n - 1) + fib(n - 2);
  }

  static int gcd(int m, int n) {
    if (n == 0)
      return m;
    return gcd(n, m % n);
  }

  static void insertSort(int[] arr, int k) {
    if (k == 0) {
      return;
    }
    //对前k-1个元素排序
    insertSort(arr, k - 1);
    //把位置k的元素插入到前面的部分
    int x = arr[k];
    int index = k - 1;
    while (index > -1 && x < arr[index]) {
      arr[index + 1] = arr[index];
      index--;
    }
    arr[index + 1] = x;
  }

  public static void main(String[] args) {
    // f2(8,10);
    // int res = f3(new int[]{1, 2, 3, 4, 5}, 0);
    // System.out.println(res);
    // System.out.println(reverse("abcd", 3));
    long now = System.currentTimeMillis();
    System.out.println(fib(50));
    Util.duration(now);
    // System.out.println("gcd:" + gcd(16, 12));
    // int[] arr = {2, 3, 1, 5, 4};
    // insertSort(arr, 4);
    // Util.print(arr);

  }
}
