package org.lanqiao.algo.elementary._06_math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。
如果只有5个砝码，重量分别是1，3，9，27，81
则它们可以组合称出1到121之间任意整数重量（砝码允许放在左右两个盘中）。

本题目要求编程实现：对用户给定的重量，给出砝码组合方案。
例如：
用户输入：
5
程序输出：
9-3-1
用户输入：
19
程序输出：
27-9+1

要求程序输出的组合总是大数在前小数在后。
可以假设用户的输入的数字符合范围1~121。
* */

/**
 用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。
 如果有无限个砝码，但它们的重量分别是1，3，9，27，81，……等3的指数幂
 神奇之处在于用它们的组合可以称出任意整数重量（砝码允许放在左右两个盘中）。

 本题目要求编程实现：对用户给定的重量，给出砝码组合方案，重量<1000000。
 例如：
 用户输入：
 5
 程序输出：
 9-3-1
 用户输入：
 19
 程序输出：
 27-9+1

 要求程序输出的组合总是大数在前小数在后。
 可以假设用户的输入一定是一个大于0的整数。
 */
public class Case01_天平称重 {
  public static void main(String[] args) {
    System.out.println(Integer.toString(1000000, 3));
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    // m1(N);
    //转成3进制
    final String x = Integer.toString(N, 3);
    //翻转后转成字符数组
    char[] arr = new StringBuilder(x).reverse().toString().toCharArray();
    //容器放处理之后的0 -1 1
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '2') {
        list.add(0, -1);//-1插在开头
        if (i == arr.length - 1) {
          list.add(0, 1);//最后一个字符,进位
        } else {
          ++arr[i + 1];//否则,对下一个数字加1
        }
      } else if (arr[i] == '3') {
        list.add(0, 0);//插入0
        //更高位进1
        if (i == arr.length - 1) {
          list.add(0, 1);
        } else {
          ++arr[i + 1];
        }
      } else {
        list.add(0, arr[i] - '0');
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 1) sb.append("+").append((int) Math.pow(3, list.size() - i - 1));
      if (list.get(i) == -1) sb.append("-").append((int) Math.pow(3, list.size() - i - 1));
    }
    System.out.println(sb.substring(1));
  }

  private static void m1(int n) {
    int[] s = {0, 1, -1};
    for (int a = 0; a < 3; a++) {
      for (int b = 0; b < 3; b++) {
        for (int c = 0; c < 3; c++) {
          for (int d = 0; d < 3; d++) {
            for (int e = 0; e < 3; e++) {
              if (s[a] * 81 + s[b] * 27 + s[c] * 9 + s[d] * 3 + s[e] * 1 == n) {
                // System.out.println(s[a] + "*81+" + s[b] + "*27+" + s[c] + "*9+" + s[d] + "*3+" + s[e] + "*1");
                // return;
                StringBuilder sb = new StringBuilder();
                if (s[a] == 1) sb.append("81");
                if (s[b] == 1) sb.append("+27");
                if (s[b] == -1) sb.append("-27");
                if (s[c] == 1) sb.append("+9");
                if (s[c] == -1) sb.append("-9");
                if (s[d] == 1) sb.append("+3");
                if (s[d] == -1) sb.append("-3");
                if (s[e] == 1) sb.append("+1");
                if (s[e] == -1) sb.append("-1");
                if (sb.charAt(0) == '+' || sb.charAt(0) == '-')
                  System.out.println(sb.substring(1));
                else
                  System.out.println(sb.toString());
                return;
              }
            }
          }
        }
      }
    }
  }
}
