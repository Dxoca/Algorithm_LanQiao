package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

/*
有n项工作,每项工作分别在si时间开始,在ti时间结束.

对于每项工作,你都可以选择参与与否.如果选择了参与,那么自始至终都必须全程参与.

此外,参与工作的时间段不能重复(即使是开始的瞬间和结束的瞬间的重叠也是不允许的).

你的目标是参与尽可能多的工作,那么最多能参与多少项工作呢?

1≤n≤100000

1≤si≤ti≤10^9

输入:

第一行:n
第二行:n个整数空格隔开,代表n个工作的开始时间
第三行:n个整数空格隔开,代表n个工作的结束时间

样例输入:

5
1 3 1 6 8
3 5 2 9 10

样例输出:

3

说明:选取工作1,3,5
 */
public class Case03_区间调度问题 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] s = new int[n];
    int[] t = new int[n];
    Job[] jobs = new Job[n];
    for (int i = 0; i < n; i++) {
      s[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      t[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      jobs[i] = new Job(s[i], t[i]);
    }

    Arrays.sort(jobs);
    int res = f(n, jobs);
    System.out.println(res);
  }

  private static int f(int n, Job[] jobs) {
    int cnt = 1;
    int y = jobs[0].t;
    for (int i = 0; i < n; i++) {
      if (jobs[i].s > y) {
        cnt++;
        y = jobs[i].t;
      }
    }
    return cnt;
  }

  /**
   * 必须实现排序规则
   */
  private static class Job implements Comparable<Job> {
    int s;
    int t;

    public Job(int s, int t) {
      this.s = s;
      this.t = t;
    }

    @Override
    public int compareTo(Job other) {
      int x = this.t - other.t;
      if (x == 0)
        return this.s - other.s;
      else
        return x;
    }
  }
}
