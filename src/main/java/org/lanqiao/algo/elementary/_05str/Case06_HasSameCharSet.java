package org.lanqiao.algo.elementary._05str;

import java.util.HashMap;
import java.util.Map;

/**
 * 询问两个串是否由相同的字符集生成
 */
public class Case06_HasSameCharSet {
  /**
   * 限制串的组成的字符时ASCII
   * @param s1
   * @param s2
   * @return
   */
  static boolean check(String s1, String s2) {
    int[] help = new int[256];
    //扫描s1
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      if (help[c] == 0)
        help[c] = 1;
    }
    //扫描s2
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      if (help[c] == 0)
        return false;
    }
    return true;
  }

  static boolean check2(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    //扫描s1
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      if (map.get(c) == null) {
        map.put(c, 1);
      }
    }
    //扫描s2
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      if (map.get(c) == null)//这说明c不在map的key列表中
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    boolean res = check2("abcde", "deabccadcd");
    System.out.println(res);
  }
}
