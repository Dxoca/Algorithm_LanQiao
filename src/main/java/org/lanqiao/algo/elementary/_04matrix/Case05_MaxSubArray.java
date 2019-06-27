package org.lanqiao.algo.elementary._04matrix;

import org.lanqiao.algo.util.Util;

import java.util.Arrays;
import java.util.Date;

/**
 * 求和最大的连续子数组,有可能不唯一，返回一个即可
 */
public class Case05_MaxSubArray {
  // 暴力法破解 Θ(n²)
  static void findByForce(int[] arr) {
    int maxSum = arr[0];

    for (int j = 0; j < arr.length; j++) {
      int sum = arr[j];// 某个元素为子数组的第一个元素
      int maxOfJ = sum;

      for (int i = j + 1; i < arr.length; i++) {
        sum += arr[i];// 累加后续元素
        if (sum > maxOfJ) {
          maxOfJ = sum;
        }
      }
      if (maxOfJ > maxSum) {
        maxSum = maxOfJ;
      }
    }
    System.out.println(maxSum);
  }

  // 递推法 Θ(n)
  static int findByDp(int[] arr) {
    // System.out.println("======="+arr.length);
    if (arr.length == 0) return 0;
    int sumJ = arr[0];  // 前J个元素的最大贡献
    int max = sumJ;
    int left = 0, right = 0;
    for (int j = 1; j < arr.length; j++) {
      if (sumJ >= 0) {  // 左子表的最大和为正，继续向后累加
        sumJ += arr[j];
      } else {
        sumJ = arr[j];
        left = j;//丢弃前部分和的同时,更新left
      }

      if (sumJ > max) {
        max = sumJ;
        right = j;//更新max的同时更新right
      }
    }
    // System.out.println(max+",left="+left+",right:"+right);
    return max;
  }

  public static void main(String[] args) {
    int[] arr = Util.getRandomArr(10000, -100, 100);
    System.out.println("数组：" + Arrays.toString(arr));
    long now = new Date().getTime();
    findByForce(arr);
    long next1 = new Date().getTime();
    System.out.println("暴力法，时间消耗：" + (next1 - now));

    findByDp(arr);
    long next2 = new Date().getTime();
    System.out.println("递推法，时间消耗：" + (next2 - next1));


  }
}