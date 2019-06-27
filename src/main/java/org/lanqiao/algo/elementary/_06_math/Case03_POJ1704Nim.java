package org.lanqiao.algo.elementary._06_math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sample Input
 2
 3
 1 2 3
 8
 1 5 6 7 9 12 14 17
 Sample Output
 Bob will win
 Georgia will win
 */
public class Case03_POJ1704Nim {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int caseNum = sc.nextInt();
    int[][] data = new int[caseNum][];
    for (int i = 0; i < caseNum; i++) {
      int k = sc.nextInt();
      data[i] = new int[k];
      for (int j = 0; j < k; j++) {
        data[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < caseNum; i++) {
      String res = deal(data[i]);
      System.out.println(res);
    }
  }

  private static String deal(int[] A) {
    int len = A.length;
    Arrays.sort(A);//7 3 2 9  最坑之处
    int res = 0;
    if ((len & 1) == 1) {//奇数
      for (int i = 0; i < len; i += 2) {
        res ^= (i == 0) ? (A[0] - 1) : (A[i] - A[i - 1] - 1);
      }
    } else {
      for (int i = 1; i < len; i += 2) {
        res ^= (A[i] - A[i - 1] - 1);
      }
    }
    if (res == 0) {
      return "Bob will win";
    } else {
      return "Georgia will win";
    }

  }
}
