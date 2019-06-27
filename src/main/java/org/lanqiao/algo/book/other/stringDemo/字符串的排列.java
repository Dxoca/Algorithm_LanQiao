package org.lanqiao.algo.book.other.stringDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 字符串的排列 {
  public ArrayList<String> Permutation(String str) {
    char[] arr = str.toCharArray();
    Arrays.sort(arr);
    ArrayList<String> res = new ArrayList<>();
    perm(res, arr, "");
    return res;
  }

  /**
   *
   * @param res
   * @param arr
   */
  void perm(ArrayList<String> res, char[] arr, String prefix) {
    if (prefix.length() == arr.length) {
      int index = Collections.binarySearch(res, prefix);
      if (index < 0) {
        res.add(prefix);
        return;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      String nPrefix = prefix + arr[i];
      if (ok(i, arr, nPrefix))
        perm(res, arr, nPrefix);
    }

  }

  private boolean ok(int x, char[] arr, String now) {
    int count1 = 0;//数组中该字符的个数
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == arr[x])
        count1++;
    }
    int count2 = 0;//now中该字符的个数
    for (int i = 0; i < now.length(); i++) {
      if (now.charAt(i) == arr[x])
        count2++;
    }
    return count2 <= count1;
  }

  public static void main(String[] args) {
    System.out.println(new 字符串的排列().Permutation("aabc"));
  }
}
