package org.lanqiao.algo.book.cc150;

import java.util.*;

public class _18_11MaxSquare {
  /**
   * 使用动态规划
   * left[i][j]: 坐标[i,j]的左边有连续相同的数个数，包含自己
   * above[i][j]: 坐标[i,j]的上边有连续相同的数个数，包含自己
   * 初始值：left[i][j]=1; above[i][j]=1
   * 递推式：
   *      left[i][j]=left[i][j-1]+1,      mat[i][j]==mat[i][j-1];
   *      left[i][j]=1,                   mat[i][j]!=mat[i][j-1];
   *      above[i][j]=above[i-1][j]+1,    mat[i][j]==mat[i-1][j];
   *      above[i][j]=1,                  mat[i][j]!=mat[i-1][j];
   * 在递推的过程中求解： mat[i][j]==mat[i][j-1]&&mat[i][j]==mat[i-1][j]
   * @param mat
   * @param n
   * @return
   */
  public int maxSubMatrix(int[][] mat, int n) {
    int max = 1;
    int[][] left = new int[n][n];
    int[][] above = new int[n][n];
    initial(mat, n, left, above);
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (mat[i - 1][j] != mat[i][j] || mat[i][j - 1] != mat[i][j]) {
          if (mat[i - 1][j] != mat[i][j]
              && mat[i][j - 1] != mat[i][j]) {
            left[i][j] = 1;
            above[i][j] = 1;
          } else if (mat[i][j - 1] != mat[i][j]) {
            left[i][j] = 1;
            above[i][j] = above[i - 1][j] + 1;
          } else {
            above[i][j] = 1;
            left[i][j] = left[i][j - 1] + 1;
          }
        } else {
          left[i][j] = left[i][j - 1] + 1;
          above[i][j] = above[i - 1][j] + 1;
          int min = Math.min(left[i][j - 1], above[i - 1][j]);
          for (int k = min; k > 0 && min >= max; k--) {//此处求解结果
            if (above[i][j - min] >= (min + 1)
                && left[i - min][j] >= (min + 1)) {
              max = Math.max(max, min + 1);
              break;
            }
          }
        }
      }
    }
    return max;
  }

  public void initial(int[][] mat, int n, int[][] left, int[][] above) {
    left[0][0] = 1;
    Arrays.fill(above[0], 1);
    for (int i = 1; i < n; i++) {
      left[i][0] = 1;
      if (mat[0][i] != mat[0][i - 1]) {
        left[0][i] = 1;
      } else {
        left[0][i] = left[0][i - 1] + 1;
      }
    }
    for (int i = 1; i < n; i++) {
      if (mat[i][0] != mat[i - 1][0]) {
        above[i][0] = 1;
      } else {
        above[i][0] = above[i - 1][0] + 1;
      }
    }
  }
}