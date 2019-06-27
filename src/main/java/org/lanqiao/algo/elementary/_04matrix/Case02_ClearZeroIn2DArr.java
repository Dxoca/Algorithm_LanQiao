package org.lanqiao.algo.elementary._04matrix;

import org.lanqiao.algo.util.Util;

public class Case02_ClearZeroIn2DArr {
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4, 100},
        {5, 6, 7, 0, 101},
        {9, 0, 11, 12, 102},
        {13, 14, 15, 16, 103},
        {104, 105, 106, 107, 103},
    };
    solve(matrix);
    Util.printMatrix(matrix);
  }

  static void solve(int[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;
    //记录哪些行出现了0
    int[] rowRecord = new int[M];
    //记录哪些列出现了0
    int[] colRecord = new int[N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 0) {
          rowRecord[i] = 1;
          colRecord[j] = 1;
        }
      }
    }
    for (int row = 0; row < M; row++) {
      for (int col = 0; col < N; col++) {
        //当前的行或者列，被标记了，这个元素就应该变为0
        if (rowRecord[row] == 1 || colRecord[col] == 1) {
          matrix[row][col] = 0;
        }
      }
    }
  }
}
