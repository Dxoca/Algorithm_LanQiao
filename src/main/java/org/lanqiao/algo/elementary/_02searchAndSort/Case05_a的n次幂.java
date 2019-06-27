package org.lanqiao.algo.elementary._02searchAndSort;

public class Case05_a的n次幂 {
  public static void main(String[] args) {
    int n = 15;
    int a = 2;
    int res = pow0(a, n);
    System.out.println(res);
    res = pow(a, -1);
    System.out.println(res);
  }

  //O(n)
  private static int pow0(int a, int n) {
    int res = 1;
    for (int i = 0; i < n; i++) {
      res *= a;
    }
    return res;
  }

  private static int pow(int a, int n) {
    if (n == 0) return 1;

    int res = a;
    int ex = 1;
    //能翻
    while ((ex << 1) <= n) {
      //翻
      res = res * res;
      //指数
      ex <<= 1;
    }
    //不能翻
    //差n-ex次方没有去乘到结果里面
    return res * pow(a, n - ex);
  }

}
