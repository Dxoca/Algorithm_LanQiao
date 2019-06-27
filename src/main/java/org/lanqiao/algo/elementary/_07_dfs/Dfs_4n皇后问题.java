package org.lanqiao.algo.elementary._07_dfs;

/**
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个n*n的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。

 给定一个int n，请返回方法数，保证n小于等于15
 */
public class Dfs_4n皇后问题 {
  static int n;
  static int cnt;

  static int[] rec;

  public static void main(String[] args) {
    n = 4;
    rec = new int[4];
    dfs(0);
    System.out.println(cnt);
  }

  /**
   *
   * @param row 当前正在处理的行
   */
  private static void dfs(int row) {
    if (row == n) {
      cnt++;
      return;
    }
    //依次尝试在某列上放一个皇后
    for (int col = 0; col < n; col++) {
      boolean ok = true;
      //检验这个皇后是否和之前已经放置的皇后有冲突
      for (int i = 0; i < row; i++) {
        if (rec[i] == col || i + rec[i] == row + col || rec[i] - i == col - row) {
          ok = false;
          break;
        }
      }
      /*=======这里可以认为是剪枝=======*/
      //这一行的这一列可以放
      if (ok) {
        rec[row] = col; //标记
        dfs(row + 1); //继续找下一行
        // rec[row]=0; //恢复原状，这种解法这里是否恢复状态都行，为什么？
      }
    }
  }

}
