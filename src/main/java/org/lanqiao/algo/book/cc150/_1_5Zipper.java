package org.lanqiao.algo.book.cc150;

/**
 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 若压缩后的字符串没有变短，则返回原先的字符串。
 给定一个string iniString为待压缩的串(长度小于等于10000)，
 保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
测试样例
"aabcccccaaa"
返回："a2b1c5a3"
 */
public class _1_5Zipper {
  public static void main(String[] args) {
    String res = zipString("abc");
    System.out.println(res);
  }

  public static String zipString(String src) {
    int count = 0;  // 记录前一个字符的重复次数
    char last = 0; // 上一个字符
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < src.length(); i++) {
      char charAt = src.charAt(i);
      if (sb.length() == 0) { // 处理第一个字符
        sb.append(charAt);
        count++;
      } else {
        if (last == charAt) {  // 和上一个字符相同
          count++;
        } else {              // 和上一个字符不同
          sb.append(count).append(charAt);
          count = 1;          // 重置为1
        }
      }
      last = charAt;
    }
    //考虑最后一个字符的重复次数
    if (count >= 1) {
      sb.append(count);
    }
    //比较新字符串和原字符串
    if (sb.length() >= src.length()) {
      return src;
    }
    return sb.toString();
  }
}
