package org.lanqiao.algo.elementary._06_math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Case09_Poj1006Biorhythms {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int t = 1;
    List<long[]> aList = new ArrayList<long[]>();
    List<Long> dList = new ArrayList<Long>();
    while (sc.hasNext()) {
      long[] a = {sc.nextLong(), sc.nextLong(), sc.nextLong()};
      long d = sc.nextLong();
      if (a[0] == -1 && a[1] == -1 && a[2] == -1 && d == -1) break;
      else {
        aList.add(a);
        dList.add(d);
      }
    }
    for (int i = 0; i < aList.size(); i++) {
      long[] a = aList.get(i);
      long d = dList.get(i);
      long[] m = {23, 28, 33};
      long res = MyExtGcd.linearEquationGroup(a, m);
      while (res <= d) {
        res += 21252;
      }
      System.out.println("Case " + (t++) + ": the next triple peak occurs in " + (res - d) + " days.");
    }
  }

  private static class MyExtGcd {
    static long x;
    static long y;

    public static long linearEquationGroup(long[] a, long[] m) throws Exception {
      int len = a.length;
      if (len == 0 && a[0] == 0) return m[0];

      for (int i = 1; i < len; i++) {
        //这里往前看是两个方程
        long a2_a1 = a[i] - a[i - 1];
        long d = linearEquation(m[i - 1], -m[i], a2_a1);
        //现在的x是y1,用y1求得一个特解
        long x0 = a[i - 1] + m[i - 1] * x;
        long lcm = m[i - 1] * m[i] / d;
        a[i] = (x0 % lcm + lcm) % lcm;//x0变成正数
        m[i] = lcm;
      }
      //合并完之后,只有一个方程 : x = a[len-1] (% m[len-1])
      return a[len - 1] % m[len - 1];
    }

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
