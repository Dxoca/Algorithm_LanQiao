package org.lanqiao.algo.elementary._03sort;

import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/**
 * 解决最小可用id问题： 在非负数组（乱序）中找到最小的可分配的id（从1开始编号）
 */
public class Case04_MinFreeId {
  //  O(N²) 暴力解法:从1开始依次探测每个自然数是否在数组中
  static int find1(int[] arr) {
    int i = 1;
    while (true) {
      if (Util.indexOf(arr, i) == -1) {
        return i;
      }
      i++;
    }
  }

  //  NlogN
  static int find2(int[] arr) {
    Arrays.sort(arr);//NlogN
    int i = 0;
    while (i < arr.length) {
      if (i + 1 != arr[i]) { //不在位的最小的自然数
        return i + 1;
      }
      i++;
    }
    return i + 1;
  }

  /**
   * 改进1：
   * 用辅助数组
   *
   */
  public static int find3(int[] arr) {
    int n = arr.length;
    int[] helper = new int[n + 1];
    for (int i = 0; i < n; i++) {
      if (arr[i] < n + 1)
        helper[arr[i]] = 1;
    }
    for (int i = 1; i <= n; i++) {
      if (helper[i] == 0) {
        return i;
      }
    }
    return n + 1;
  }

  /**
   * 改进2，分区，递归
   * 问题可转化为：n个正数的数组A，如果存在小于n的数不在数组中，必然存在大于n的数在数组中， 否则数组排列恰好为1到n
   * @param arr
   * @param l
   * @param r
   * @return
   */
  public static int find4(int[] arr, int l, int r) {
    if (l > r)
      return l + 1;
    int midIndex = l + ((r - l) >> 1);//中间下标
    int q = Case02_OrderStatistic.selectK(arr, l, r, midIndex - l + 1);//实际在中间位置的值
    int t = midIndex + 1;//期望值
    if (q == t) {//左侧紧密
      return find4(arr, midIndex + 1, r);
    } else {//左侧稀疏
      return find4(arr, l, midIndex - 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 8, 9, 10, 11, 10000};
    arr = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11};
    arr = new int[1000 * 1000];

    for (int i = 0; i < 1000 * 1000; i++) {
      if (i == 900000) {
        arr[i] = arr.length + 10;
      } else {
        arr[i] = i + 1;
      }
    }
    // arr = Util.getRandomArrWithoutRepetition(10, 1, 15);
    // Util.print(arr);
    long now = System.currentTimeMillis();
    System.out.println(find2(arr));
    Util.duration(now);


    now = System.currentTimeMillis();
    System.out.println(find3(arr));
    Util.duration(now);


    now = System.currentTimeMillis();
    System.out.println(find4(arr, 0, arr.length - 1));
    Util.duration(now);
  }
}