package org.lanqiao;

import org.assertj.core.api.Assertions;
import org.lanqiao.algo.elementary._03sort.exam.Exam15_MaxHeap;
import org.lanqiao.algo.elementary._03sort.exam.Exam16_CombineString;
import org.lanqiao.algo.elementary._03sort.exam.Exam17_NewOrder;
import org.lanqiao.algo.elementary._04matrix.exam.Exam18_TransformMatrix;
import org.lanqiao.algo.elementary._08_dp.exam.Exam34_Painter;
import org.lanqiao.algo.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class 生成数据 {
  public static void main(String[] args) throws FileNotFoundException {
    // exam34();
    long r = 100_000_000L * 100_000_000 % 1000_000_000;
    System.out.println(r);
  }

  private static void exam34() throws FileNotFoundException {
    //  Exam34_Painter
    Scanner sc = new Scanner(System.in);
    int index = 0;
    PrintStream sysout = System.out;
    String fileName = "Exam34_Painter";
    while (true) {
      int m = sc.nextInt();
      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + (index) + ".in")));
      for (int j = 0; j < m; j++) {
        int N = sc.nextInt();
        int[] arr = Util.getRandomArr(N + 1, 0, 1000);
        System.out.print(N + " ");
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
      System.out.print(0);
      System.out.flush();

      index++;
    }

  }

  private static void exam18() throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int index = 0;
    PrintStream sysout = System.out;
    String fileName = "Exam18_TransformMatrix";
    while (true) {
      int N = sc.nextInt();
      int[][] matrix = new int[N][N];
      for (int i = 0; i < N; i++) {
        matrix[i] = Util.getRandomArr(N, 1, 50);
      }
      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + (index) + ".in")));
      System.out.println(N);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          System.out.print(matrix[i][j] + (j == N - 1 ? "" : " "));
        }
        System.out.println();
      }
      System.out.flush();

      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + +(index) + ".out")));
      long now = System.currentTimeMillis();
      int[][] res = Exam18_TransformMatrix.transformImage(matrix, N);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          System.out.print(res[i][j] + (j == N - 1 ? "" : " "));
        }
        System.out.println();
      }
      System.out.flush();

      System.setOut(sysout);
      Util.duration(now);//统计时间

      index++;
      if (index == 5) break;
    }
  }

  private static void exam17() throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int index = 0;
    PrintStream sysout = System.out;
    String fileName = "Exam17_NewOrder";
    while (true) {
      int N = sc.nextInt();
      String order = Util.getRandomLowerCaseStringWithOutRepeation(26);
      char[] caa = order.toCharArray();
      Arrays.sort(caa);
      Assertions.assertThat(new String(caa).equals("abcdefghijklmnopqrstuvwxyz"));
      String[] arr = Util.getRandomLowerCaseStrArr(N, 10);
      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + (index) + ".in")));
      System.out.println(N);
      System.out.println(order);
      for (int i = 0; i < N; i++) {
        System.out.println(arr[i]);
      }
      System.out.flush();

      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + +(index) + ".out")));
      long now = System.currentTimeMillis();
      Exam17_NewOrder.solve(arr, order);
      System.out.flush();

      System.setOut(sysout);
      Util.duration(now);//统计时间

      index++;
      if (index == 5) break;
    }
  }

  private static void exam16() throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int index = 0;
    PrintStream sysout = System.out;
    String fileName = "Exam16_CombineString";
    while (true) {
      int N = sc.nextInt();
      String[] arr = Util.getRandomLowerCaseStrArr(N, 10);
      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + (index) + ".in")));
      System.out.println(N);
      for (int i = 0; i < N; i++) {
        System.out.print(arr[i] + (i == N - 1 ? "" : " "));
      }
      System.out.flush();

      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + +(index) + ".out")));
      long now = System.currentTimeMillis();
      Exam16_CombineString.solve(arr, N);
      System.out.flush();

      System.setOut(sysout);
      Util.duration(now);//统计时间

      index++;
      if (index == 5) break;
    }
  }

  private static void exam15() throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int index = 4;
    PrintStream sysout = System.out;
    while (true) {
      int N = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = Util.getRandomArr(N, 1, 200);
      String fileName = "Exam15_MaxHeap";
      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + (index) + ".in")));
      System.out.println(N);
      System.out.println(k);
      for (int i = 0; i < N; i++) {
        System.out.print(arr[i] + (i == N - 1 ? "" : " "));
      }
      System.out.flush();
      System.setOut(new PrintStream(new File("/Volumes/WORK/算法基础课@郑未/测验/" + fileName + "/tests/" + fileName + +(index) + ".out")));
      long now = System.currentTimeMillis();
      Exam15_MaxHeap.solve(N, k, arr);
      System.out.flush();

      System.setOut(sysout);
      Util.duration(now);//统计时间

      index++;
    }
  }
}
