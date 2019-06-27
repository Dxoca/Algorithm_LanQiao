package org.lanqiao.algo.elementary._08_dp;

import org.lanqiao.algo.util.Util;

import static java.lang.Math.max;

/**
 * 最长递增子序列的长度
 * 输入 4 2 3 1 5 6
 * 输出 3 （因为 2 3 5组成了最长递增子序列）
 *
 * @author zhengwei 20171209
 */
public class Case15_LIS {
    static int[] arr = {4, 2, 3, 1, 5, 6, 4, 8, 5, 9};

    public static void main(String[] args) {
        System.out.println(f(arr));
        System.out.println(dp(arr));
        System.out.println(dp1(arr));
    }

    /*在优化之后，可以达到O(NlgN)*/
    private static int dp1(int[] arr) {
        dp = new int[arr.length + 1];
        dp[1] = arr[0];//长度为1的最长递增子序列，初始化为第一个元素
        int p = 1;//记录dp更新的最后位置
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp[p]) {
                dp[p + 1] = arr[i];
                p++;
            } else {
                //扫描dp数组，替换第一个比arr[i]大的dp
                // for (int j = 0; j <= p; j++) {
                //   if (dp[j]>arr[i]){
                //     dp[j]=arr[i];
                //   }
                // }
                int indexOfFirstBigger = Util.indexOfFirstBigger(dp, arr[i], 0, p);
                if (indexOfFirstBigger != -1)
                    dp[indexOfFirstBigger] = arr[i];
            }
        }

        return p;
    }

    private static int f(int[] arr) {
        int maxCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int p = i;
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[p]) {
                    cnt++;
                    p = j;
                }
            }
            // if (cnt>maxCnt){
            //   maxCnt=cnt;
            // }
            maxCnt = max(maxCnt, cnt);
        }
        return maxCnt;

    }

    static int[] dp = new int[arr.length];

    private static int dp(int[] arr) {
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int cnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    cnt = max(cnt, dp[j] + 1);
                }
            }
            dp[i] = cnt;

        }
        int ans = -1;
        for (int i = 0; i < dp.length; i++) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }

}
