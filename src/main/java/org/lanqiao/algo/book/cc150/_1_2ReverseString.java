package org.lanqiao.algo.book.cc150;

/*
请实现一个算法，翻转一个给定的字符串.
测试样例：
"This is nowcoder"
返回："redocwon si sihT"

*/
public class _1_2ReverseString {
  public String reverseString(String iniString) {
      int len = iniString.length();
      char[] charArr = new char[len];
      for(int i = 0; i < len; i++){
        charArr[i] = iniString.charAt(len-1-i);
      }
      return new String(charArr);
  }
}

/*
public class Reverse {
    public String reverseString(String iniString) {
        StringBuffer sb = new StringBuffer(iniString);
        return sb.reverse().toString();
    }
}*/