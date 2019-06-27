package org.lanqiao.algo.elementary._06_math;

import java.util.Scanner;

/**
 * (A/B)%9973,求余,除法不满足交换性,可改为求B关于9973的逆元x,
 * 这样结果等价于Ax%9973等价于x*A%9973等价于xn%9973,
 */
public class Case08_Hdu1576 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int n = sc.nextInt();
      int B = sc.nextInt();
      try {
        MyExtGcd.inverseElement(B, 9973);
        long x = MyExtGcd.x;//x是B的关于9973的逆元
        // x = (x%9973 + 9973) % 9973;
        System.out.println(x * n % 9973);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private static class MyExtGcd {
    static long x;
    static long y;

    /**
     * 求逆元
     * ax = 1 (% mo),gcd(a,mo)=1
     * ax+mo*y=1
     * */
    public static long inverseElement(long a, long mo) throws Exception {

      long d = linearEquation(a, mo, 1);//ax+mo*y=1
      x = (x % mo + mo) % mo;//保证x>0
      return d;
    }

    /**
     * 线性方程
     * ax+by=m 当m时gcd(a,b)倍数时有解
     * 等价于ax = m mod b*/
    public static long linearEquation(long a, long b, long m) throws Exception {
      long d = ext_gcd(a, b);
      //m不是gcd(a,b)的倍数,这个方程无解
      if (m % d != 0) throw new Exception("无解");
      long n = m / d;//约一下,考虑m是d的倍数
      x *= n;
      y *= n;
      return d;
    }

    /**
     * 扩展欧几里得
     * 调用完成后xy是ax+by=gcd(a,b)的解*/
    public static long ext_gcd(long a, long b) {

      if (b == 0) {
        x = 1;
        y = 0;
        return a;
      }
      long res = ext_gcd(b, a % b);
      //x,y已经被下一层递归更新了,ppt中所说的x0和y0
      long x1 = x;//备份x
      x = y;//更新x
      y = x1 - a / b * y;//更新y
      return res;
    }

  }
}
