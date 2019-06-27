package org.lanqiao.algo.util;

public class FunctionTime {
  public static void m1() {
    long max = 0;
    for (int i = 0; i < 100000; i++) {
      int t = i;
      long factorial = i;
      while (t > 1) {
        t = t - 1;
        factorial *= t;
      }
      max = Math.max(max, factorial);
    }
  }

  public static void m2() {
    long max = 0;
    for (int i = 0; i < 100000; i++) {
      long factorial = getFactorial(i);
      max = Math.max(max, factorial);
    }
  }

  private static long getFactorial(int i) {
    int t = i;
    long factorial = i;
    while (t > 1) {
      t = t - 1;
      factorial *= t;
    }
    return factorial;
  }

  public static void main(String[] args) {
    long now = System.currentTimeMillis();
    m1();
    System.out.println("时间消耗" + (System.currentTimeMillis() - now));

    now = System.currentTimeMillis();
    m2();
    System.out.println("时间消耗" + (System.currentTimeMillis() - now));
  }
}
