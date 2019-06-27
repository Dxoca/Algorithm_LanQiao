package org.lanqiao.algo.elementary._05str;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Case13_HDU1358 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> list = new ArrayList<String>();

    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      String s = sc.next();
      list.add(s);

    }
    for (int j = 0; j < list.size(); j++) {
      String s = list.get(j);

      int[] next = next(s);
      System.out.println("Test case #" + (j + 1));
      boolean flag = false;
      for (int i = 2; i < next.length; i++) {
        int k = next[i];
        int t = i - k;
        if (i % t == 0 && i / t > 1) {
          System.out.println(i + " " + i / t);
        }
      }
      // if (!flag) System.out.println(0+" "+0);
      System.out.println();
    }
  }

  private static int[] next(String s) {
    if (s == null || s.length() == 0) return null;
    int[] next = new int[s.length() + 1];
    next[0] = -1;
    if (s.length() == 1)
      return next;
    next[1] = 0;
    int j = 1;
    int k = next[j];
    while (j < s.length()) {
      if (k == -1 || s.charAt(j) == s.charAt(k)) {
        next[++j] = ++k;
      } else {
        k = next[k];
      }
    }
    return next;
  }
}

