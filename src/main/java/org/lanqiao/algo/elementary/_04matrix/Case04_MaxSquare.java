package org.lanqiao.algo.elementary._04matrix;

/**
 * 给定一个N×N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度。 
 　　例如： 
 {0, 1, 1, 1, 1},
 {0, 1, 0, 0, 1},
 {0, 1, 0, 0, 1},
 {0, 1, 1, 1, 1},
 {0, 1, 0, 1, 1}　
 　　其中，边框全是1的最大正方形的大小是4*4，返回4
 */
public class Case04_MaxSquare {
  public static void main(String[] args) {
    int[][] A = {
        {0, 1, 1, 1, 1},
        {0, 1, 0, 1, 0},
        {0, 1, 1, 1, 1},
        {0, 1, 1, 1, 1},
        {0, 1, 0, 1, 1}
    };
    A = new int[][]{
        {1, 1, 1, 1},
        {1, 0, 0, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 1},
    };
    generateHelpRec(A);
    print(rec, A.length);
    int res = solve(A);
    System.out.println(res);
  }

  private static void print(int[][][] rec, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(rec[i][j][0] + "," + rec[i][j][1] + "\t");
      }
      System.out.println();
    }
  }

  /**
   * 记录每个元素往右和往下有多少个连续的1
   * @param A
   */
  private static void generateHelpRec(int[][] A) {
    int N = A.length;
    rec = new int[N][N][2];
    int row = N - 1;
    //初始化最后一行
    for (int j = N - 1; j >= 0; j--) {
      int value = A[row][j];
      if (value == 1) {
        if (j == N - 1) {
          rec[row][j][0] = 1;//右侧连续1的个数
        } else {
          //A的元素值为1，rec在这个位置的连续1的个数=右边位置的连续1的个数+1
          rec[row][j][0] = rec[row][j + 1][0] + 1;
        }
        //最后一行的下方的1的连续数==1
        rec[row][j][1] = 1;
      }
    }
    row--;
    for (int i = row; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        int value = A[i][j];
        // 利用右边和下边已经生产的数据来推出现在这个位置上右侧和下方有多少个1
        if (value == 1) {
          if (j == N - 1)
            rec[i][j][0] = 1;//右侧连续1的个数
          else
            rec[i][j][0] = rec[i][j + 1][0] + 1;

          rec[i][j][1] = rec[i + 1][j][1] + 1;//向下连续1的个数
        }
      }
    }

  }

  static int[][][] rec;

  //O(n³)
  private static int solve(int[][] A) {
    int N = A.length;
    int n = N;
    while (n > 0) {
      for (int i = 0; i < N; i++) {
        if (i + n > N) break;
        l3:
        for (int j = 0; j < N; j++) {
          if (j + n > N) break;
          //
          // //检查四个边
          // int r = i, c = j;
          // while (c < j + n) {
          //   if (A[r][c++] == 0) continue l3;
          // }
          // c--;
          // while (r < i + n) {
          //   if (A[r++][c] == 0)
          //     continue l3;
          // }
          // r--;
          // while (c >= j) {
          //   if (A[r][c--] == 0)
          //     continue l3;
          // }
          // c++;
          // while (r >= i) {
          //   if (A[r--][c] == 0)
          //     continue l3;
          // }
          if (check(i, j, n))
            return n;
        }
      }
      n--;
    }
    return n;
  }

  //O(1的)
  private static boolean check(int i, int j, int n) {
    //左上角那个点往右数的1的数目要≥n
    //左上角那个点往下数的1的数目要≥n
    //右上角那个点往下数的1的数目要≥n
    //左下角那个点往右数的1的数目要≥n

    if (rec[i][j][0] >= n && rec[i][j][1] >= n && rec[i][j + n - 1][1] >= n && rec[i + n - 1][j][0] >= n)
      return true;
    return false;
  }
}
