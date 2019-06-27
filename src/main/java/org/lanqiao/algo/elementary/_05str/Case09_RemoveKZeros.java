package org.lanqiao.algo.elementary._05str;

import org.assertj.core.api.Assertions;

/**
 * 移除字符串中连续出现的K个0
 *
 * 可以用扫描字符数组的解法，但是用正则表达式更为快捷
 */
public class Case09_RemoveKZeros {
  //0{3}
  static String remove(String iniString, int k) {
    String regexp = "0{" + k + "}";
    return iniString.replaceAll(regexp, "");
  }

  static String remove1(String iniString, int k) {
    char[] arr = iniString.toCharArray();
    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      char c = arr[i];
      if (c == '0') {
        count++;
      } else {
        for (int j = 0; j < count % k; j++) {
          sb.append('0');
        }
        sb.append(c);
        count = 0;
      }
    }
    for (int j = 0; j < count % k; j++) {
      sb.append('0');
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Assertions.assertThat(remove1("A0B", 3)).isEqualTo("A0B");
  }
}
