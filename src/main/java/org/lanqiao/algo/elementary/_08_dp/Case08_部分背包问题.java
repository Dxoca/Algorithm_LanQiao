package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;

/**
 有n个物体，第i个物体的重量为wi，价值为vi。在总重量不超过C的情况下让总价值尽量高。

 每一个物体都可以只取走一部分，价值和重量按比例计算。

 求最大总价值

 注意：每个物体可以只拿一部分，因此一定可以让总重量恰好为C。
 */
public class Case08_部分背包问题 {
  public static void main(String[] args) {
    int[] w = {1, 2, 3, 4, 5};
    int[] v = {3, 4, 3, 1, 4};
    int n = w.length;
    double C = 10;
    Obj[] objs = new Obj[n];
    for (int i = 0; i < n; i++) {
      objs[i] = new Obj(w[i], v[i]);
    }

    Arrays.sort(objs);
    double c = C;
    double maxValue = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (objs[i].w <= c) {
        maxValue += objs[i].v;
        c -= objs[i].w;
      } else {
        maxValue += objs[i].v * (c / objs[i].w);
        break;
      }
    }
    System.out.println(maxValue);
  }

  private static class Obj implements Comparable<Obj> {
    int w;
    int v;

    public Obj(int w, int v) {
      this.w = w;
      this.v = v;
    }

    public double getPrice() {
      return v / (double) w;
    }

    @Override
    public int compareTo(Obj o) {
      if (this.getPrice() == o.getPrice()) return 0;
      else if (this.getPrice() < o.getPrice()) return -1;
      else return 1;
    }

    @Override
    public String toString() {
      return "Obj{" +
          "w=" + w +
          ", v=" + v +
          ", price=" + getPrice() +
          '}';
    }
  }
}
