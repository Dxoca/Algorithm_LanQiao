package org.lanqiao.algo.book.cc150;

import org.apache.commons.lang3.StringUtils;

/**
 请实现一个算法，确定一个字符串的所有字符是否全都不同(有没有重复字符)。

 * @author zhengwei lastmodified 2017年7月25日
 *
 */
public class _1_1Different {
  public boolean checkDifferent(String iniString) {
    if (StringUtils.isEmpty(iniString)) {
      return true;
    }
    int[] flag = new int[128];
    //扫描字符串
    for (int i = 0; i < iniString.length(); i++) {
      int c = (int) (iniString.charAt(i));
      if (flag[c] > 0) return false;
      else flag[c]++;
    }
    return true;
  }

  public static void main(String[] args) {
    String iniString = "BarackObama";
    iniString = "abcdeafg";
    System.out.println(new _1_1Different().checkDifferent(iniString));
  }
}

/*其他解法
public boolean checkDifferent(String iniString) {   
return !iniString.matches(".*(.)(.*\\1).*");
}

“(.)”表示一个捕获组，“\\1”表示一个反向引用，也就是说“\\1”与“(.)”这两个位置的值可以相同，其他位置都是".*",
表示匹配0~n个任意字符。总的来说，这个正则表达式是匹配出现重复字符的字符串。
*/