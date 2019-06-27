package org.lanqiao.algo.elementary._07_dfs;

import java.util.Scanner;

/*
你一定听说过“数独”游戏。
如下图所示，玩家需要根据9×9盘面上的已知数字，推理出所有剩余空格的数字，并满足每一行、每一列、每一个同色九宫内的数字均含1-9，不重复。
数独的答案都是唯一的，所以，多个解也称为无解。
本图的数字据说是芬兰数学家花了3个月的时间设计出来的较难的题目。但对会使用计算机编程的你来说，恐怕易如反掌了。
本题的要求就是输入数独题目，程序输出数独的唯一解。我们保证所有已知数据的格式都是合法的，并且题目有唯一的解。
格式要求，输入9行，每行9个数字，0代表未知，其它数字为已知。
输出9行，每行9个数字表示数独的解。
输入：

005300000
800000020
070010500
400005300
010070006
003200080
060500009
004000030
000009700

程序应该输出：

145327698
839654127
672918543
496185372
218473956
753296481
367542819
984761235
521839764

再例如，输入：

800000000
003600000
070090200
050007000
000045700
000100030
001000068
008500010
090000400

程序应该输出：

812753649
943682175
675491283
154237896
369845721
287169534
521974368
438526917
796318452
*/
public class Dfs1_数独 {
  public static void main(String[] args) {
    // System.out.println((char)('0'+1));
    Scanner sc = new Scanner(System.in);
    char[][] table = new char[9][];
    for (int i = 0; i < 9; i++) {
      table[i] = sc.nextLine().toCharArray();
    }
    dfs(table, 0, 0);
  }

  private static void dfs(char[][] table, int x, int y) {
    if (x == 9) {
      print(table);
      System.exit(0);
    }
    if (table[x][y] == '0') {//虚位以待
      for (int k = 1; k < 10; k++) {
        if (check(table, x, y, k)) {
          // f = false;
          table[x][y] = (char) ('0' + k);
          dfs(table, x + (y + 1) / 9, (y + 1) % 9);//处理下一个状态
        }
      }
      table[x][y] = '0';//回溯

    } else {
      dfs(table, x + (y + 1) / 9, (y + 1) % 9);//处理下一个状态
    }

  }

  private static void print(char[][] table) {
    for (int i = 0; i < 9; i++) {
      System.out.println(new String(table[i]));
    }
  }

  private static boolean check(char[][] table, int i, int j, int k) {
    //检查同行和同列
    for (int l = 0; l < 9; l++) {
      if (table[i][l] == (char) ('0' + k)) return false;
      if (table[l][j] == (char) ('0' + k)) return false;
    }
    //检查小九宫格
    for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
      for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
        if (table[l][m] == (char) ('0' + k)) return false;
      }
    }
    return true;
  }

}
