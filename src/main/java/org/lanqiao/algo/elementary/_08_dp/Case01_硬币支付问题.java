package org.lanqiao.algo.elementary._08_dp;

import java.util.Scanner;

import static java.lang.Math.min;

/*
硬币问题

有1元,5元,10元,50元,100元,500元的硬币各c1,c5,c10,c50,c100,c500枚.

现在要用这些硬币来支付A元,最少需要多少枚硬币?

假定本题至少存在一种支付方案.

0≤ci≤10^9

0≤A≤10^9

输入:

第一行有六个数字,分别代表从小到大6种面值的硬币的个数

第二行为A,代表需支付的A元

样例:

输入

3 2 1 3 0 2
620

输出

6
*/
public class Case01_硬币支付问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            cnts[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        int res = f(A, 5);
        System.out.println(res);
    }

    static int[] cnts = new int[6];
    static int[] coins = {1, 5, 10, 50, 100, 500};

    /**
     * 尽量先用大面值,因为不用大面值,将使用更多的小面值硬币,一定得不到最优解
     *
     * @param A
     * @param cur
     * @return
     */
    static int f(int A, int cur) {
        if (A <= 0) return 0;
        if (cur == 0) return A;

        int coinValue = coins[cur];
        int x = A / coinValue;//金额有多少个coinValue
        int cnt = cnts[cur];//当前面值的硬币有cnt个
        int t = min(x, cnt);
        return t + f(A - t * coinValue, cur - 1);//用t个当前面值,剩下的继续处理
    }
}
