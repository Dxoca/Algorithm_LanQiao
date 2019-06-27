package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

/*
A group of N people wishes to go across a river with only one boat, which can at most carry two persons.
Therefore some sort of shuttle arrangement must be arranged in order to row the boat back and forth so that all people may cross.
Each person has a different rowing speed; the speed of a couple is determined by the speed of the slower one.
Your job is to determine a strategy that minimizes the time for these people to get across.

Input

The first line of the input contains a single integer T (1 <= T <= 20), the number of test cases.
Then T cases follow.
The first line of each case contains N, and the second line contains N integers giving the time for each people to cross the river.
Each case is preceded by a blank line. There won't be more than 1000 people and nobody takes more than 100 seconds to cross.

Output

For each test case, print a line containing the total number of seconds required for all the N people to cross the river.

Sample Input
1
4
1 2 5 10
Sample Output
17
 */
public class Case02_POJ_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            //排序
            Arrays.sort(speed);
            f(n, speed);
        }
    }

    /**
     * speed已经排序
     *
     * @param n
     * @param speed
     */
    private static void f(int n, int[] speed) {
        int left = n;
        int ans = 0;
        while (left > 0) {
            if (left == 1) {//只有1人
                ans += speed[0];
                break;
            } else if (left == 2) {//只有两人
                ans += speed[1];
                break;
            } else if (left == 3) {//有三人
                ans += speed[2] + speed[0] + speed[1];
                break;
            } else {
                //1，2出发，1返回，最后两名出发，2返回
                int s1 = speed[1] + speed[0] + speed[left - 1] + speed[1];
                //1，3出发，1返回，1，4出发，1返回，1，2过河
                int s2 = speed[left - 1] + speed[left - 2] + 2 * speed[0];
                ans += min(s1, s2);
                left -= 2;//左侧是渡河的起点，left代表左侧的剩余人数
            }
        }
        System.out.println(ans);
    }
}
