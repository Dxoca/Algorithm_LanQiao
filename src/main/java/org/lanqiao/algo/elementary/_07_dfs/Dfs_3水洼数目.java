package org.lanqiao.algo.elementary._07_dfs;

import java.util.Scanner;

/*
有一个大小为 N*M 的园子，雨后积起了水。八连通的积水被认为是连接在一起的。请求出
园子里总共有多少水洼？（八连通指的是下图中相对 W 的*的部分）

    ***
    *W*
    ***

限制条件

 N, M ≤ 100

 样例:

 输入
    N=10, M=12

园子如下图（'W'表示积水， '.'表示没有积水）

W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.

输出

    3

 */
public class Dfs_3水洼数目 {
  private static int n;
  private static int m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    char[][] a = new char[n][];
    for (int i = 0; i < n; i++) {
      a[i] = sc.next().toCharArray();
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 'W') {
          dfs(a, i, j);//清除一个水洼
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }

  private static void dfs(char[][] a, int i, int j) {
    a[i][j] = '.';

    for (int k = -1; k < 2; k++) {//-1,0,1
      for (int l = -1; l < 2; l++) {//-1,0,1
        if (k == 0 && l == 0) continue;

        if (i + k >= 0 && i + k <= n - 1 && j + l >= 0 && j + l <= m - 1) {
          if (a[i + k][j + l] == 'W')
            dfs(a, i + k, j + l);
        }
      }
    }
  }
}
