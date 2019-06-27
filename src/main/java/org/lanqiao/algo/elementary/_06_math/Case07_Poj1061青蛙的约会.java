package org.lanqiao.algo.elementary._06_math;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * https://vjudge.net/problem/POJ-1061
 */
public class Case07_Poj1061青蛙的约会 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long x = sc.nextInt();//坐标
    long y = sc.nextInt();//坐标
    long m = sc.nextInt();//A一次跳
    long n = sc.nextInt();//B一次跳
    long L = sc.nextInt();//维度总线

    //x+m*k = y+n*k mod L
    //(m-n)*k = y-x mod L
    //(m-n)*xx + L*yy =  y-x
    long a = m - n;
    long b = L;
    m = y - x;
    long d = 0;
    try {
      d = Case05_ExtGcd.linearEquation(a, b, m);//求解线性方程
      long x0 = Case05_ExtGcd.x;//可能小于0
      b /= d;//约一下
      b = abs(b);
/*============这里是AC的关键==============*/
      x0 = (x0 % b + b) % b;//要求大于0的第一个解
      System.out.println(x0);
    } catch (Exception e) {
      System.out.println("Impossible");
    }
  }

  private static class Case05_ExtGcd {
    static long x;
    static long y;

    /**调用完成后xy是ax+by=gcd(a,b)的解*/
    public static long ext_gcd(long a, long b) {

      if (b == 0) {
        x = 1;
        y = 0;
        return a;
      }
      long res = ext_gcd(b, a % b);
      long x1 = x;//备份x
      x = y;//更新x
      y = x1 - a / b * y;//更新y
      return res;
    }

    /**ax+by=m 当m时gcd(a,b)倍数时有解
     * 等价于ax = m mod b*/
    public static long linearEquation(long a, long b, long m) throws Exception {
      long d = ext_gcd(a, b);
      if (m % d != 0) throw new Exception("无解");
      long n = m / d;//约一下,考虑m是d的倍数
      x *= n;
      y *= n;
      return d;
    }

  }
}


