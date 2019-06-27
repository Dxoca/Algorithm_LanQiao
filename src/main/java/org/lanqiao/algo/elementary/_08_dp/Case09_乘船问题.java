package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;

/**
 有n个人，第i个人重量为wi。每艘船的最大载重量均为C，且最多只能乘两个人。用最少的船装载所有人。

 贪心策略：考虑最轻的人i，如果每个人都无法和他一起坐船（重量和超过C），则唯一的方案是每个人坐一艘
 否则，他应该选择能和他一起坐船的人中最重的一个j

 求需要船的数量
 */
public class Case09_乘船问题 {
  public static void main(String[] args) {
    int[] w = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int n = w.length;
    int c = 10;

    Arrays.sort(w);
    int cntOfPerson = n;
    int cntOfBoat = 0;
    int p1 = 0;
    int p2 = n - 1;
    while (cntOfPerson > 0) {
      if (p1 + p2 > c) {
        p2--;
        cntOfPerson--;
        cntOfBoat++;
      } else {
        p1++;
        p2--;
        cntOfPerson -= 2;
        cntOfBoat++;
      }
    }
    System.out.println(cntOfBoat);
  }
}
