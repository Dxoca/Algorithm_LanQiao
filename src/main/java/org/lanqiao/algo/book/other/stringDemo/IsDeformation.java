package org.lanqiao.algo.book.other.stringDemo;

import org.assertj.core.util.Preconditions;

import java.util.Arrays;

/**
 * 判断两个字符串是否互为变形词
 */
public class IsDeformation {
  boolean isDeformation(String s1,String s2){
    Preconditions.checkNotNull(s1);
    Preconditions.checkNotNull(s2);
    if (s1.length()!=s2.length()) {
      return false;
    }
    if (s1!=s2) {
      return false;
    }
    char[] s1Arr = s1.toCharArray();
    char[] s2Arr = s2.toCharArray();
    Arrays.sort(s1Arr);
    Arrays.sort(s2Arr);
    return Arrays.equals(s1Arr, s2Arr);
  }
}
