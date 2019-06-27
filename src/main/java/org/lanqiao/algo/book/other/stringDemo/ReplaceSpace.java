package org.lanqiao.algo.book.other.stringDemo;

public class ReplaceSpace {
  public String replaceSpace(StringBuffer str) {
    int spaceCount = 0;
    int len = str.length();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == ' ') {
        spaceCount++;
      }
    }
    int nLen = len + 2 * spaceCount;
    str.setLength(nLen);
    int p1 = len - 1;
    int p2 = nLen - 1;
    while (p1 >= 0) {
      char c = str.charAt(p1--);
      if (c == ' ') {
        str.setCharAt(p2--, '0');
        str.setCharAt(p2--, '2');
        str.setCharAt(p2--, '%');
      } else {
        str.setCharAt(p2--, c);
      }
    }
    return str.toString();
  }

  public static void main(String[] args) {
    System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer("We are happy.")));
  }
}
