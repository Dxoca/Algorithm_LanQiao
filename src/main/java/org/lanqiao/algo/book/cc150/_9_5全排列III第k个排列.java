package org.lanqiao.algo.book.cc150;

/**
 * LeetCode60 n个数的排列组合找出字典序的第k个排列
 * The set[1,2,3,…,n]contains a total of n! unique permutations.
 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the k th permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.

 时间限制：1秒
 */
public class _9_5全排列III第k个排列 {
  public static void main(String[] args) {
    String s = "123";
    permutation("", s.toCharArray());
  }

  final static int k = 3;
  static int count = 0;

  private static void permutation(String prefix, char[] arr) {
    if (prefix.length() == arr.length) {//前缀的长度==字符集的长度,一个排列就完成了
      // System.out.println(prefix);
      count++;
      if (count == k) {
        System.out.println("-------:" + prefix);
        System.exit(0);
      }
    }
    //每次都从头扫描,只要该字符可用,我们就附加到前缀后面,前缀变长了
    for (int i = 0; i < arr.length; i++) {
      char ch = arr[i];
      //这个字符可用:在pre中出现次数<在字符集中的出现次数
      if (count(prefix, ch) < count(arr, ch)) {
        permutation(prefix + ch, arr);
      }
    }
  }

  private static int count(char[] arr, char ch) {
    int cnt = 0;
    for (char c : arr
        ) {
      if (c == ch) cnt++;
    }
    return cnt;
  }


  private static int count(String str, char ch) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ch) cnt++;
    }
    return cnt;
  }
}
