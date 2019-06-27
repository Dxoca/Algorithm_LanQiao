package org.lanqiao.algo.elementary._04matrix;

/**
 * z字形打印矩阵
 */
public class Case03_PrintMatrixZig {
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        // {13, 14, 15, 16},
    };
    print(matrix);
  }

  static void print(int[][] matrix) {
    int r = 0, m = matrix.length;
    int c = 0, n = matrix[0].length;
    boolean l2r = true;//从左到右
    while (r < m && c < n) {
      //从左下到右上的斜线
      if (l2r) {
        System.out.print(matrix[r][c] + " ");
        //现在在第一行，列未到边界，这是只能向右走
        if (r == 0 && c < n - 1) {
          l2r = !l2r;//方向切换
          c++;
          continue;
        } else if (r > 0 && c == n - 1) {//现在在最后一列，只能向下走
          l2r = !l2r;
          r++;
          continue;
        } else {//继续走上坡
          r--;
          c++;
        }
      } else {//反，走下坡
        System.out.print(matrix[r][c] + " ");
        if (c == 0 && r < m - 1) {//走到第一列，只能往下走
          l2r = !l2r;
          r++;
          continue;
        } else if (r == m - 1) {//到最后一行，只能往右走
          l2r = !l2r;
          c++;
          continue;
        } else {
          r++;
          c--;
        }
      }

    }

  }
}
