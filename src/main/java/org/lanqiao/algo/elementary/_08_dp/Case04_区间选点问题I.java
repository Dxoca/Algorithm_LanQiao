package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

// 数轴上有n个闭区间[ai,bi]。取尽量少的点，使得每个区间内都至少有一个点（不同区间内含的点可以是同一个）。
/*
Intervals
You are given n closed, integer intervals [ai, bi] and n integers c1, ..., cn.
Write a program that:
reads the number of intervals, their end points and integers c1, ..., cn from the standard input,
computes the minimal size of a set Z of integers which has at least ci common elements with interval [ai, bi], for each i=1,2,...,n,
writes the answer to the standard output.

Input
The first line of the input contains an integer n (1 <= n <= 50000) -- the number of intervals.
The following n lines describe the intervals. The (i+1)-th line of the input contains three integers ai,
bi and ci separated by single spaces and such that 0 <= ai <= bi <= 50000 and 1 <= ci <= bi - ai+1.

Output
The output contains exactly one integer equal to the minimal size of set Z
sharing at least ci elements with interval [ai, bi], for each i=1,2,...,n.
Sample Input
5
3 7 3
8 10 3
6 8 1
1 3 1
10 11 1
Sample Output
6
 */
//POJ1201
public class Case04_区间选点问题I {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Interval[] intervals = new Interval[n];
    for (int i = 0; i < n; i++) {
      intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    Arrays.sort(intervals);//按区间右端点排序

    int max = intervals[n - 1].t;//右端最大值
    int[] axis = new int[max + 1];//标记数轴上的点是否已经被选中
    // int[] sums = new int[max + 1];
    for (int i = 0; i < n; i++) {
      //1.查阅区间中有多少个点
      int s = intervals[i].s;//起点
      int t = intervals[i].t;//终点
      int cnt = sum(axis, s, t);//找到这个区间已经选点的数量，sums[t] - sums[s - 1];//效率低
      //  2.如果不够，从区间右端开始标记，遇标记过的就跳过
      intervals[i].c -= cnt;//需要新增的点的数量
      while (intervals[i].c > 0) {
        if (axis[t] == 0) {//从区间终点开始选点
          axis[t] = 1;
          // updateSums(t,sums);//更新前缀和
          intervals[i].c--;//进一步减少需要新增的点的数量
          t--;
        } else {//这个点已经被选过了
          t--;
        }
      }

    }
    System.out.println(sum(axis, 0, max));
  }

  /**
   * 统计数轴axis上s-t区间已经有多少个点被选中
   * @param axis
   * @param s
   * @param t
   * @return
   */
  private static int sum(int[] axis, int s, int t) {
    int sum = 0;
    for (int i = s; i <= t; i++) {
      sum += axis[i];
    }
    return sum;
  }

  private static void updateSums(int t, int[] sums) {
    for (int i = t; i < sums.length; i++) {
      sums[i]++;
    }
  }

  private static class Interval implements Comparable<Interval> {
    int s;
    int t;
    int c;

    public Interval(int s, int t, int c) {
      this.s = s;
      this.t = t;
      this.c = c;
    }

    @Override
    public int compareTo(Interval other) {
      int x = this.t - other.t;
      if (x == 0)
        return this.s - other.s;
      else
        return x;
    }
  }

}
