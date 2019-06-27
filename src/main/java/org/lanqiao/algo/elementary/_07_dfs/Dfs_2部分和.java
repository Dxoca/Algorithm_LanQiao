package org.lanqiao.algo.elementary._07_dfs;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

/*
给定整数序列a1,a2,...,an,判断是否可以从中选出若干数,使它们的和恰好为k.

    1≤n≤20

    -10^8≤ai≤10^8

    -10^8≤k≤10^8

样例:

输入

    n=4
    a={1,2,4,7}
    k=13
输出:

    Yes (13 = 2 + 4 + 7)

*/
public class Dfs_2部分和 {

  private static int kk;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int k = sc.nextInt();//13
    kk = k;
    dfs(a, k, 0, new ArrayList<Integer>());
  }


  private static void dfs(int[] a, int k, int cur, ArrayList<Integer> ints) {
    if (k == 0) {
      System.out.print("Yes (" + kk + " = ");
      int size = ints.size();
      for (int i = 0; i < size; i++) {
        System.out.print(ints.get(i) + (i == size - 1 ? "" : " + "));
      }
      System.out.println(")");
      exit(0);
    }
    if (k < 0 || cur == a.length) return;

    dfs(a, k, cur + 1, ints);//不要cur这个元素

    ints.add(a[cur]);
    int index = ints.size() - 1;
    dfs(a, k - a[cur], cur + 1, ints);
    ints.remove(index);//回溯
  }
}
