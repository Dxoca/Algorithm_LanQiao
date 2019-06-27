package org.lanqiao.algo.elementary._07_dfs;

import java.util.Scanner;

/**
 * 输入正整数n，对1-n进行排列，使得相邻两个数之和均为素数，
 * 输出时从整数1开始，逆时针排列。同一个环应恰好输出一次。
 * n<=16
 *
 * 如输入：6
 * 输出：
 * 1 4 3 2 5 6
 * 1 6 5 2 3 4
 */
public class Dfs_5素数环 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] r = new int[n];
    r[0] = 1;
    dfs(n, r, 1);
  }

  private static void dfs(int n, int[] r, int cur) {
    if (cur == n && isP(r[0] + r[n - 1])) {//填到末尾了,还有首尾相加为素数才算成功
      print(r);
      return;
    }

    for (int i = 2; i <= n; i++) {//尝试用每个数字填到cur这个位置
      if (check(r, i, cur)) {//r中没有i这个数,且和上一个数之和为素数
        r[cur] = i;//试着将i放在cur位置,往前走一步
        dfs(n, r, cur + 1);
        r[cur] = 0;//回溯
      }

    }
  }

  private static void print(int[] r) {
    for (int i = 0; i < r.length; i++) {
      System.out.print(r[i] + (i == r.length - 1 ? "" : " "));
    }
    System.out.println();
  }

  private static boolean check(int[] r, int i, int cur) {
    for (int e : r) {
      if (e == i || !isP(r[cur - 1] + i)) return false;
    }
    return true;
  }

  private static boolean isP(int k) {
    for (int i = 2; i * i <= k; i++) {
      if (k % i == 0) return false;
    }
    return true;

  }
}
