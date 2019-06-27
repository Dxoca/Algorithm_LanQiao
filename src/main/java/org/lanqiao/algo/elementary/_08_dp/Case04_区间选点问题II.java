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
//用树状数组才可以不超时
public class Case04_区间选点问题II {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Interval[] intervals = new Interval[n];
    for (int i = 0; i < n; i++) {
      intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    Arrays.sort(intervals);//按区间右端点排序

    int max = intervals[n - 1].t;//右端最大值
    int[] axis = new int[max + 1];
    int[] c = new int[max + 2];
    // int[] sums = new int[max + 1];
    for (int i = 0; i < n; i++) {
      //1.查阅区间中有多少个点
      int s = intervals[i].s;//起点
      int t = intervals[i].t;//终点
      int cnt = sum(t + 1, c, max + 1) - sum(s, c, max + 1);//sum(axis,s,t);//sums[t] - sums[s - 1];//效率低
      //  2.如果不够，从区间右端开始标记，遇标记过的就跳过
      intervals[i].c -= cnt;
      while (intervals[i].c > 0) {
        if (axis[t] == 0) {
          axis[t] = 1;
          update(t + 1, 1, c, max + 1);
          intervals[i].c--;
          t--;
        } else {
          t--;
        }
      }

    }
    System.out.println(sum(max + 2, c, max + 1));
  }

  /**
   * 更新树状数组c，注意i是项数，不是下标，而是下标+1*/
  private static void update(int i, int delta, int[] c, int n) {
    for (; i <= n; i += lowbit(i)) {
      c[i] += delta;
    }
  }

  /**
   * 前i项和，注意：i不是下标
   * @param i
   * @return
   */
  private static int sum(int i, int[] c, int n) {
    int sum = 0;
    if (i > n)
      i = n;
    for (; i > 0; i -= lowbit(i)) {
      sum += c[i];
    }
    return sum;
  }


  /**
   * 它通过公式来得出k，其中k就是该值从末尾开始1的位置。
   * 然后将其得出的结果加上x自身就可以得出当前节点的父亲节点的位置
   * 或者是x减去其结果就可以得出上一个父亲节点的位置。
   * 比如当前是6，二进制就是0110，k为2，那么6+2=8，C(8)则是C(6)的父亲节点的位置；
   * 相反，6-2=4，则是C(6)的上一个父亲节点的位置。*/
  static int lowbit(int x) {
    return x - (x & (x - 1));
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
