package org.lanqiao.algo.elementary._05str;

/*
* 将字符串按单词翻转,如here you are 翻转成are you here*/
public class Case08_WordReverse {
  public static void main(String[] args) {
    String res = reverse("");
    System.out.println(res);
  }

  //首先将整个字符串按照字符翻转,再找到每个单词,将单词翻转
  static String reverse(String src) {
    String s1 = reverseString(src);
    //切割单词
    String[] words = s1.split("\\s");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      sb.append(reverseString(words[i]) + " ");
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }

  public static String reverseString(String iniString) {
    StringBuilder sb = new StringBuilder(iniString);
    return sb.reverse().toString();
  }
}
