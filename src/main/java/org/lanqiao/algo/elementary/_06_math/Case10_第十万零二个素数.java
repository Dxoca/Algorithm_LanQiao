package org.lanqiao.algo.elementary._06_math;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.StrictMath.log;

/*
* 自然数n之内的素数个数n/ln(n)
* */
public class Case10_第十万零二个素数 {
  public static void main(String[] args) {
    long now = System.currentTimeMillis();
    //nlognlogn
    m1(100000);
    System.out.println("耗时：" + (System.currentTimeMillis() - now) + "ms");

    now = System.currentTimeMillis();
    int cnt = 0;
    long x = 2;
    while (cnt < 100000) {
      if (Case09_PrimeNumber.isPrime(x))
        cnt++;
      x++;
    }
    System.out.println(x - 1);
    System.out.println("耗时：" + (System.currentTimeMillis() - now) + "ms");
  }

  /**
   * 求第N个素数
   * @param N
   */
  private static void m1(int N) {
    //N是第N个素数
    //已知在整数X内大概有X/log(X)个素数
    //现在我们要逆推：要想求第N个素数，我们的整数范围是什么
    //length就是整数范围
    int n = 2;
    while (n / log(n) < N) {
      n++;
    }
    //开辟一个数组，下标是自然数，值是标记
    //基本思路是筛选法，把非素数标记出来
    int[] arr = new int[n];
    int x = 2;
    while (x < n) {
      //标记过了，继续下一个
      if (arr[x] != 0) {
        x++;
        continue;
      }

      int k = 2;
      //对每个x，我们从2倍开始，对x的k倍，全部标记为-1
      while (x * k < n) {
        arr[x * k] = -1;
        k++;
      }
      x++;
    }
    // System.out.println(arr);
    //筛完之后，这个很长的数组里面非素数下标对应的值都是-1
    int sum = 0;
    for (int i = 2; i < arr.length; i++) {
      //是素数，计数+1
      if (arr[i] == 0) {
        // System.out.println(i);
        sum++;
      }
      if (sum == N) {
        System.out.println(i);
        return;
      }
    }
  }
}
