package org.lanqiao.algo.elementary._04matrix;

/**
 * 顺时针打印二维数组
 输入
 1 	2 	3 	4
 5 	6 	7 	8
 9 	10 	11 	12
 13	14	15	16
 输出
 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class Case01_Print2DArr {
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4, 100},
        {5, 6, 7, 8, 101},
        {9, 10, 11, 12, 102},
        {13, 14, 15, 16, 103},
        {104, 105, 106, 107, 103},
    };
    print(matrix);
  }

  static void print(int[][] matrix) {

    int leftUpRow = 0, leftUpCol = 0, rightDownRow = matrix.length - 1, rightDownCol = matrix[0].length - 1;
    while (leftUpRow <= rightDownRow && leftUpCol <= rightDownCol) {
      int r = leftUpRow, c = leftUpCol;
      //上面一条边
      while (c <= rightDownCol) {
        System.out.print(matrix[r][c++] + " ");
      }
      //恢复
      c = rightDownCol;
      r++;
      //右边的一条边
      while (r <= rightDownRow) {
        System.out.print(matrix[r++][c] + " ");
      }
      //恢复
      r = rightDownRow;
      c--;
      //下面一条边
      while (c >= leftUpCol) {
        System.out.print(matrix[r][c--] + " ");
      }
      //  恢复
      c = leftUpCol;
      r--;
      while (r > leftUpRow) {
        System.out.print(matrix[r--][c] + " ");
      }
      leftUpRow++;
      leftUpCol++;
      rightDownRow--;
      rightDownCol--;
    }

  }
}
