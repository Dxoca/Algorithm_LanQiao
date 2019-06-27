package org.lanqiao.algo.elementary._08_dp;

import java.util.Scanner;

/*
字典序最小问题

给一个定长为N的字符串S,构造一个字符串T,长度也为N。

起初，T是一个空串，随后反复进行下列任意操作

1. 从S的头部删除一个字符，加到T的尾部
2. 从S的尾部删除一个字符，加到T的尾部

目标是最后生成的字符串T的字典序尽可能小

1≤N≤2000
字符串S只包含大写英文字母

输入：字符串S
输出：字符串T

POJ - 3617 要求每80个字符换行输出
 */
public class Case06_字典序最小问题 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    StringBuilder ss = new StringBuilder();
    for (int i = 0; i < N; i++) {
      ss.append(sc.next());
    }
    // String s = sc.nextLine();
    f(ss.toString());

  }

  private static void f(String s) {
    String s1 = new StringBuilder(s).reverse().toString();
    int N = s.length();
    StringBuilder rs = new StringBuilder();
    int cnt = 0;
    while (rs.length() < N) {
      if (s.compareTo(s1) <= 0) {
        rs.append(s.charAt(0));
        s = s.substring(1);
      } else {
        rs.append(s1.charAt(0));
        s1 = s1.substring(1);
      }
      //字符满80个就换行
      if (rs.length() % 80 == 0) {
        System.out.println(rs.substring(cnt * 80, (cnt + 1) * 80));
        cnt++;
      }
    }
    //余数部分
    if (rs.length() > cnt * 80) {
      System.out.println(rs.substring(cnt * 80));
    }
  }
}
