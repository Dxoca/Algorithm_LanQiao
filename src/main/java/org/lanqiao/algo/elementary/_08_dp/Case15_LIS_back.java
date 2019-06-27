package org.lanqiao.algo.elementary._08_dp;

import org.lanqiao.algo.util.Util;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static org.lanqiao.algo.util.Util.*;

/**
 * 最长递增子序列的长度
 * dp[i] = max{dp[j]}+1 ,0<=j<i且arr[j]<state[i]
 * 上述为递归公式
 * @author zhengwei 20171209
 */
public class Case15_LIS_back {

  public static int len(int[] arr, int index) {
    int max = 0;
    for (int i = 0; i < index; i++) {
      //对于每个小于当前值的元素
      if (arr[i] < arr[index]) {
        //递归求出其lis
        int _len = len(arr, i);
        //找到最大的lis
        if (_len > max)
          max = _len;// 替换max
      }
    }
    return max + 1;
  }

  public static int len(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      int _len = len(arr, i);
      if (_len > max)
        max = _len;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = getRandomArr(10, 1, 100);
    print(arr);
    System.out.println("---开始----");
    Instant now = Instant.now();
    // int lis = len(state);
    // System.out.println("持续时间为：" + (Instant.now().toEpochMilli() - now.toEpochMilli()) + "毫秒");
    // System.out.println(lis);

    now = Instant.now();
    int lis = dp2(arr);
    System.out.println("持续时间为：" + (Instant.now().toEpochMilli() - now.toEpochMilli()) + "毫秒");
    System.out.println(lis);
  }

  private static Map<Integer, Integer> cache = new HashMap<>(10011 * 4 / 3);

  /**
   * 递推打表法 N² 10^5的输入规模，10^10的运算量级，消耗时间超过100秒
   * @param arr
   * @return
   */
  private static int dp1(int[] arr) {
    int n = arr.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;// 对角线初始化为1
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i][j] = cache.get(j) + 1;
        } else
          dp[i][j] = 1;
      }
      final int maxOf = maxOf(dp[i]);
      cache.put(i, maxOf);
      if (maxOf > max)
        max = maxOf;
    }
    //printMatrix(dp);
    return max;
  }

  /**
   * NlogN时间复杂度
   * @param arr
   * @return
   */
  private static int dp2(int[] arr) {
    int n = arr.length;
    //辅助空间 dp[i] 该位置有记录，说明目前的最长递增子序列的长度为i+1，且dp[i]记录了该递增子序列的最后一个数
    int[] dp = new int[n];
    int right = 0; // 记录辅助空间现在填充到的位置
    dp[0] = arr[0];
    //扫描每个元素
    for (int i = 1; i < n; i++) {
      //dp是一个递增序列，在dp中找比当前元素大的元素，返回下标
      int biggerIndex = Util.indexOfFirstBigger(dp, arr[i], 0, right);
      // 如果dp中没有比当前元素更大的值，说明dp要扩展
      if (biggerIndex == -1) {
        dp[++right] = arr[i];
      } else { // 找到了比当前元素大的值，dp无法扩展，进行替换，使得dp序列尽量小，且维持有序
        dp[biggerIndex] = arr[i];
      }
      Util.print(dp);
    }
    return right + 1;
  }

}
