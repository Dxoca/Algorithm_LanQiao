package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.util.Util;

/**
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，矩阵中的元素为int范围内。</int></vector></int></vector>
 测试样例：
 [[1,2,3],[0,1,2],[0,0,1]]
 返回：[[0,0,3],[0,0,0],[0,0,0]]
 */
public class _1_7Clearer {
  public static void main(String[] args) {
    long[][] mat = new long[][]{
        {1, 0, 2, 3, 4},
        {1, 2, 2, 0, 4},
        {1, 4, 2, 3, 4},
        {0, 2, 2, 3, 4},
        {1, 2, 2, 3, 4}
    };
    Util.printMatrix(mat);
    System.out.println("----------------");
    Util.printMatrix(new _1_7Clearer().clearZero(mat, 5));
  }

  public long[][] clearZero(long[][] mat, int n) {
    int[] rows = new int[n];
    int[] cols = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          rows[i] = 1;
          cols[j] = 1;
        }
      }
    }
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (rows[row] == 1 || cols[col] == 1) {
          mat[row][col] = 0;
        }
      }
    }

    return mat;
  }
}
