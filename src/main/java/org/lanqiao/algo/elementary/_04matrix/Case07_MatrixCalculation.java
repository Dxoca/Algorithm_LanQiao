package org.lanqiao.algo.elementary._04matrix;

import java.util.Scanner;

/*
* M N
* 随后的M行,每行有N个数据(空格隔开),这些是A的数据
* 随后的M行,每行有N个数据(空格隔开),这些是B的数据
*
* */
public class Case07_MatrixCalculation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int[][] A = new int[M][N];
    int[][] B = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        A[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        B[i][j] = sc.nextInt();
      }
    }
    //A+2X = B
    //  X = (B-A)/2
    int[][] X = getX(A, B);
  }

  private static int[][] getX(int[][] a, int[][] b) {
    return new int[0][];
  }
}
