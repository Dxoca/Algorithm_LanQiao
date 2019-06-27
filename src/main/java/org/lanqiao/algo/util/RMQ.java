package org.lanqiao.algo.util;

import static java.lang.Math.*;

public class RMQ {
  public static Result deal(int[] A) {
    int len = A.length;
    double a = log(len) / log(2);
    int n = (int) floor(a) + 1;
    int[][] minn = new int[len][n];
    int[][] maxn = new int[len][n];
    for (int i = 0; i < len; i++) {
      minn[i][0] = A[i];
      maxn[i][0] = A[i];
    }
    int j = 1;
    while (j < n) {
      for (int i = 0; i < len; i++) {
        int half = 1 << (j - 1);//一半的个数
        if (i + half < len) {
          minn[i][j] = min(minn[i][j - 1], minn[i + half][j - 1]);  //最小值=i~一半即前半段的最小值,i+一半,后半段的最小值
          maxn[i][j] = max(maxn[i][j - 1], maxn[i + half][j - 1]);  //最小值=i~一半即前半段的最小值,i+一半,后半段的最小值
        }
      }
      j++;
    }
    return new Result(minn, maxn);
  }

  static public class Result {
    public int[][] minn;
    public int[][] maxn;

    public Result(int[][] minn, int[][] maxn) {
      this.minn = minn;
      this.maxn = maxn;
    }

    public int maxQ(int i, int j) {
      int size = j - i + 1;
      int logSize = (int) floor((log(size) / log(2)));
      return max(maxn[i][logSize], maxn[j - (1 << logSize) + 1][logSize]);
    }

    public int minQ(int i, int j) {
      int size = j - i + 1;
      int logSize = (int) floor((log(size) / log(2)));
      return min(minn[i][logSize], minn[j - (1 << logSize) + 1][logSize]);
    }
  }

}
