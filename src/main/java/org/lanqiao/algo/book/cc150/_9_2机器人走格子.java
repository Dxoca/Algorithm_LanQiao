package org.lanqiao.algo.book.cc150;

/**
 有一个X*Y的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 请设计一个算法，计算机器人有多少种走法。
 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */
public class _9_2机器人走格子 {
  public static void main(String[] args) {
    System.out.println(solve(6, 6));
    System.out.println(solve1(6, 6));
  }

  /**
   * 递归形式
   * @param x
   * @param y
   * @return
   */
  public static int solve(int x, int y) {

    if (x == 1 || y == 1) return 1;

    return solve(x - 1, y) + solve(x, y - 1);
  }

  /**
   * 迭代形式
   * @param m
   * @param n
   * @return
   */
  public static int solve1(int m, int n) {
    int[][] state = new int[m + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      state[1][i] = 1;
    }
    for (int i = 1; i <= m; i++) {
      state[i][1] = 1;
    }
    for (int i = 2; i <= m; i++) {
      for (int j = 2; j <= n; j++) {
        state[i][j] = state[i][j - 1] + state[i - 1][j];
      }
    }
    return state[m][n];
  }

}
