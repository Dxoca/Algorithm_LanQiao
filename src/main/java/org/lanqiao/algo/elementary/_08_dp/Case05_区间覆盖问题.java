package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 Farmer John is assigning some of his N (1 <= N <= 25,000) cows to do some cleaning chores around the barn.

 He always wants to have one cow working on cleaning things up and has divided the day into T shifts (1 <= T <= 1,000,000),

 the first being shift 1 and the last being shift T.

 Each cow is only available at some interval of times during the day for work on cleaning.

 Any cow that is selected for cleaning duty will work for the entirety of her interval.

 Your job is to help Farmer John assign some cows to shifts so that (i) every shift has at least one cow assigned to it,

 and (ii) as few cows as possible are involved in cleaning. If it is not possible to assign a cow to each shift, print -1.

 Input
 Line 1: Two space-separated integers: N and T

 Lines 2..N+1: Each line contains the start and end times of the interval during which a cow can work.

 A cow starts work at the start time and finishes after the end time.
 Output
 Line 1: The minimum number of cows Farmer John needs to hire or -1 if it is not possible to assign a cow to each shift.
 Sample Input
 3 10
 1 7
 3 6
 6 10
 Sample Output
 2

 */
//POJ2376
public class Case05_区间覆盖问题 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int T = sc.nextInt();
    Job[] jobs = new Job[N];
    for (int i = 0; i < N; i++) {
      jobs[i] = new Job(sc.nextInt(), sc.nextInt());
    }
    Arrays.sort(jobs);
    int start = 1;//要覆盖的目标点，end覆盖该点的所有区间中右端点最右
    int end = 1;
    int ans = 1;
    for (int i = 0; i < N; i++) {

      int s = jobs[i].s;
      int t = jobs[i].t;

      if (i == 0 && s > 1) break;

      if (s <= start) {//当前区间有可能覆盖start
        end = max(t, end);//更新更右的端点
      } else {//开始下一个区间
        ans++;//上一个目标覆盖已经达成，计数加1
        start = end + 1;//更新起点，设置一个新的覆盖目标
        if (s <= start) {
          end = max(t, end);
        } else {
          break;
        }
      }
      if (end >= T) {//当前的end超越了线段的右侧
        break;
      }

    }
    if (end < T)
      System.out.println(-1);
    else
      System.out.println(ans);
  }

  private static class Job implements Comparable<Job> {
    int s;
    int t;

    public Job(int s, int t) {
      this.s = s;
      this.t = t;
    }

    /**按照区间起点排序*/
    @Override
    public int compareTo(Job other) {
      int x = this.s - other.s;
      if (x == 0)
        return this.t - other.t;
      else
        return x;
    }
  }
}
