package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;

import static java.lang.Math.max;

/*
Serling公司购买长钢条，将其切割为短钢条出售。切割工序本身没有成本支出。公司管理层希望知道最佳的切割方案。
假定我们知道Serling公司出售一段长为i英寸的钢条的价格为pi(i=1,2,…，单位为美元)。钢条的长度均为整英寸。

| 长度i | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| - | - | - | - | - | - | - | - | - | - |
价格pi | 1 | 5 | 8 | 16 | 10 | 17 | 17 | 20 | 24 | 30 |

钢条切割问题是这样的：给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，求切割钢条方案，使得销售收益rn最大。
注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割。

 */
public class Case11_钢条切割 {
  static int n = 10;
  static int[] p = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30};

  static int[] vs = new int[n + 1];

  /**
   * @param x 钢条的长度
   */
  static int r(int x) {
    if (x == 0) {
      return 0;
    }
    int ans = 0;

    for (int i = 1; i <= x; i++) {
      if (vs[x - i] == -1)
        vs[x - i] = r(x - i);

      int v = p[i - 1] + vs[x - i];
      ans = max(v, ans);
    }
    vs[x] = ans;
    return ans;
  }

  static int dp() {
    vs[0] = 0;
    for (int i = 1; i <= n; i++) {//拥有的钢条长度
      for (int j = 1; j <= i; j++) {//保留j为整段
        vs[i] = max(p[j - 1] + vs[i - j], vs[i]);
      }
    }
    return vs[n];
  }

  public static void main(String[] args) {
    Arrays.fill(vs, -1);
    int ans = r(n);
    System.out.println(ans);
    Arrays.fill(vs, 0);

    ans = dp();
    System.out.println(ans);
  }
}
