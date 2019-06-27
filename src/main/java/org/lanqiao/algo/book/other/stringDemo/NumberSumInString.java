package org.lanqiao.algo.book.other.stringDemo;

import org.assertj.core.api.Assertions;

import java.util.Objects;

/**
 * 提取字符串的减号和数字，求出最终的计算结果，--得正
 * A-1B2C45 = 46
 */
public class NumberSumInString {
  static int sumInString(String str) {
    if (Objects.isNull(str))
      return 0;
    char[] arr = str.toCharArray();
    int sum = 0;
    int num = 0;
    boolean posi = true;
    for (int i = 0; i < arr.length; i++) {
      int charNum = arr[i] - '0';
      if (charNum >= 0 && charNum <= 9) { // 数字
        num = num * 10 + charNum; // 合并连续的数字
      } else { // 字符，这时num是上次合并的数字，应该把该数字累加到sum中
        if (posi)  //上一次标记的正负
          sum = sum + num;
        else
          sum = sum - num;
        num = 0;

        if (arr[i] == '-') { // 如果遇到-号，应标记下次为负数
          posi = false;
        } else { // 其他符号，标记下次为正号
          posi = true;
        }
      }
    }
    if (num != 0) {
      if (posi)
        sum = sum + num;
      else
        sum = sum - num;
    }
    return sum;
  }

  public static void main(String[] args) {
    Assertions.assertThat(sumInString("---345D345")).isEqualTo(0);
    Assertions.assertThat(sumInString("A-1B2C45")).isEqualTo(46);
    Assertions.assertThat(sumInString("A-1B2C4-5")).isEqualTo(0);
    Assertions.assertThat(sumInString("-4567")).isEqualTo(-4567);
    Assertions.assertThat(sumInString("4567")).isEqualTo(4567);
  }
}
