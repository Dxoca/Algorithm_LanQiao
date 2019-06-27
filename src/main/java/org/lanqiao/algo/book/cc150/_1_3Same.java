package org.lanqiao.algo.book.cc150;

import java.util.Arrays;

/*
变形词:两个串有相同的字符及数量组成 abc abc ,abc cba,aabcd bcada;
给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 这里规定大小写为不同字符，且考虑字符串中的空格。
给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。
保证两串的长度都小于等于5000。
测试样例：
"Here you are","Are you here"
返回：false*/
public class _1_3Same {
  public boolean checkSam(String stringA, String stringB) {
    int len1 = stringA.length();
    int len2 = stringB.length();
    if (len1 != len2) {
      return false;
    }
    //转成字符数组
    char[] arr1 = stringA.toCharArray();
    char[] arr2 = stringB.toCharArray();
    //对它们排序
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    return Arrays.equals(arr1, arr2);
  }

}
