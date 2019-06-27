package org.lanqiao.algo.elementary._05str;

import org.apache.commons.lang3.StringUtils;

/**
 * 回文字符串
 * @author zhengwei lastmodified 2017年7月25日
 *
 */
public class Case10_Palindrome {
  public boolean isPalindrome(String src) {

    if (StringUtils.isEmpty(src)) {
      return true;
    }
    //翻转后和自己相同---回文字符串
    return src.equals(new StringBuilder(src).reverse().toString());
  }

  // ijji
  static void palindromeNumber() {
    for (int i = 1; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.println(i * 1000 + j * 100 + j * 10 + i);
      }
    }
  }

  public static void main(String[] args) {
    palindromeNumber();
  }

}
