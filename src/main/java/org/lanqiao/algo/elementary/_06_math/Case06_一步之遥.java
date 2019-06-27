package org.lanqiao.algo.elementary._06_math;

import static java.lang.Math.abs;

/**
 * 从昏迷中醒来，小明发现自己被关在X星球的废矿车里。
 矿车停在平直的废弃的轨道上。
 他的面前是两个按钮，分别写着“F”和“B”。

 小明突然记起来，这两个按钮可以控制矿车在轨道上前进和后退。
 按F，会前进97米。按B会后退127米。
 透过昏暗的灯光，小明看到自己前方1米远正好有个监控探头。
 他必须设法使得矿车正好停在摄像头的下方，才有机会争取同伴的援助。
 或许，通过多次操作F和B可以办到。

 矿车上的动力已经不太足，黄色的警示灯在默默闪烁...
 每次进行 F 或 B 操作都会消耗一定的能量。
 小明飞快地计算，至少要多少次操作，才能把矿车准确地停在前方1米远的地方。

 请填写为了达成目标，最少需要操作的次数。

 97x-127y=1
 ax+by=m
 */
public class Case06_一步之遥 {

  public static void main(String[] args) {
    try {
      long ans = ExtGcd.linearEquation(97, -127, 1);
      long x = ExtGcd.x;
      long y = ExtGcd.y;
      System.out.println(abs(x) + abs(y));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //私有的静态的内部类
  private static class ExtGcd {
    static long x, y;

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
  }
}
