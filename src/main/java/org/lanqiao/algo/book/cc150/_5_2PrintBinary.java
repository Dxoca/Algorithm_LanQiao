package org.lanqiao.algo.book.cc150;

import org.assertj.core.util.Preconditions;

public class _5_2PrintBinary {
  public static String f(double x) {
    Preconditions.checkArgument(x < 1 && x > 0, "参数应该大于0小于1");
    StringBuilder sb = new StringBuilder();
    sb.append(".");
    while (x > 0) {
      if (sb.length() >= 32) {
        return sb.toString();
      }
      double r = x * 2;
      if (r >= 1) {
        sb.append(1);
        x = r - 1;
      } else {
        sb.append(0);
        x = r;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(f(0.72));
  }

}
