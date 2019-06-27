package org.lanqiao.algo.elementary._05str;

/**
 * 判断A串是否B串的旋转字符串
 * defabd  fabdde -- true
 * @author zhengwei
 *
 */
public class Case07_IsRotate {
  public static boolean isRotate(String a, String b) {
    if (a.length() != b.length())
      return false;
    //b+b
    StringBuilder sb = new StringBuilder(b).append(b);
    //
    return sb.toString().contains(a);
  }
  
  public static void main(String[] args) {
    System.out.println(isRotate("defa", "fabdde"));
    System.out.println(isRotate("abc", "acb"));
  }
}
