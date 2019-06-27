package org.lanqiao.algo.book.leetcode;

import java.util.Stack;

/**
 * 时间限制：1秒 空间限制：32768K
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class evaluate_reverse_polish_notation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    for (String t : tokens) {
      try {
        Integer num = Integer.parseInt(t);
        stack.add(num);
      } catch (Exception e) {
        int a = stack.pop();
        int b = stack.pop();
        stack.add(get(b, a, t));
      }
    }
    return stack.pop();
  }

  private static int get(int a, int b, String t) {
    switch (t) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        return a / b;
      default:
        return 0;
    }

  }

}