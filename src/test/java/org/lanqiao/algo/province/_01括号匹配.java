package org.lanqiao.algo.province;


/**
 问题描述
 给定一个合法的括号序列，请你找出每一对匹配左右括号的位置。
 输入
 一个只包含左右小括号的序列，长度不超过100000。保证括号序列是合法的。
 输出
 对于序列中每一个左括号，输出它和与它匹配的右括号的位置。

 */

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class _01括号匹配 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    //自带排序效果的map
    TreeMap<Integer, Integer> res = new TreeMap();
    Stack<Integer> stack = new Stack<>();
    //开始解析字符串的每个字符
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      //左括号入栈
      if (c == '(') {
        stack.push(i + 1);
      } else {//遇右括号，栈顶弹出，并且找到一对括号，把下标对存储treemap
        Integer pop = stack.pop();
        res.put(pop, i + 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
