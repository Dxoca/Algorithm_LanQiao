package org.lanqiao.algo.elementary._08_dp;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;

/**
 * 求最大公共子序列问题
 * AB34C
 * A1BC2 结果为 ABC
 * 更多案例请看测试用例
 */
public class Case13_LCS {
    public static void main(String[] args) {
        Case13_LCS obj = new Case13_LCS();
        // System.out.println(obj.solution("AB34C", "A1BC2"));
        // Assertions.assertThat(obj.solution("3563243", "513141")).isEqualTo("534");
        // Assertions.assertThat(obj.solution("3069248", "513164318")).isEqualTo("3648");
        ArrayList ans = obj.dfs("AB34C", "A1BC2");
        System.out.println(ans);
        System.out.println(obj.dfs("3563243", "513141"));
        System.out.println(obj.dfs("3069248", "513164318"));
        System.out.println(obj.dfs("123", "456"));

    }

    ArrayList<Character> dfs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        ArrayList<Character> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            //求以i字符开头的公共子序列
            ArrayList<Character> list = new ArrayList<>();
            //和s2的每个字符比较
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {//如果相同
                    list.add(s1.charAt(i));
                    list.addAll(dfs(s1.substring(i + 1), s2.substring(j + 1)));
                    break;
                }
            }
            if (list.size() > ans.size()) {
                ans = list;
            }
        }
        return ans;
    }

    /**
     * 生成动规表
     *
     * @param s1
     * @param s2
     * @return
     */
    String solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1]; // 动规数组
        int flag = 0;
        // 初始化第一列
        //O(M)
        for (int i = 1; i <= len1; i++) {
            if (flag == 1) {
                dp[i][1] = 1;
            } else if (s1.charAt(i - 1) == s2.charAt(0)) {
                dp[i][1] = 1;
                flag = 1;
            } else {
                dp[i][1] = 0;
            }
        }

        flag = 0;
        //初始化第一行
        //O(N)
        for (int j = 1; j <= len2; j++) {
            if (flag == 1) {
                dp[1][j] = 1;
            } else if (s2.charAt(j - 1) == s1.charAt(0)) {
                dp[1][j] = 1;
                flag = 1;
            } else {
                dp[1][j] = 0;
            }
        }
        //O(M*N)
        for (int i = 2; i <= len1; i++) {  // M
            for (int j = 2; j <= len2; j++) {  // N
                int maxOfLeftAndUp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // dp[i][j] = Math.max(maxOfLeftAndUp, dp[i - 1][j - 1] + 1);
                    dp[i][j] = dp[i - 1][j - 1] + 1;//这样也是对的……
                } else {
                    dp[i][j] = maxOfLeftAndUp;
                }
            }
        }
        // Util.printMatrix(dp);
        return parseDp(dp, s1, s2);
    }

    /**
     * 解析动态规划表，得到最长公共子序列
     *
     * @param dp
     * @param s1
     * @param s2
     * @return
     */
    private String parseDp(int[][] dp, String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        StringBuilder sb = new StringBuilder();
        while (M > 0 && N > 0) {
            // 比左和上大，一定是当前位置的字符相等
            if (dp[M][N] > Math.max(dp[M - 1][N], dp[M][N - 1])) {
                sb.insert(0, s1.charAt(M - 1));
                M--;
                N--;
            } else {  // 一定选择的是左边和上边的大者
                if (dp[M - 1][N] > dp[M][N - 1]) {
                    M--;  //往上移
                } else {
                    N--; // 往左移
                }
            }
        }

        return sb.toString();
    }

}
