package org.lanqiao.algo.elementary.digit;

import org.assertj.core.api.Assertions;

import java.util.stream.IntStream;

public class NumberOf1Between1AndN {
  int get(int N) {
    // 递归终止条件
    if (N >= 1 && N <= 9)
      return 1;
    if (N < 1)
      return 0;

    int count = 0; // 计数器

    // 分离高位和剩余
    int high = 0;
    int other = 0;
    int digitNum = 0; // 位数少1
    int temp = N;
    while (temp / 10 != 0) {
      digitNum++;
      temp = temp / 10;
    }
    high = N / (int) Math.pow(10, digitNum);// 高位
    other = N - high * (int) Math.pow(10, digitNum);
    if (high > 1)  // 高位是否比1大，易错点
      count += (int) Math.pow(10, digitNum);
    else
      count += other + 1; // 高位为1，低位数值+1就是高位为1的数字个数，先把这个部分加起来
    count += high * digitNum * (int) Math.pow(10, digitNum - 1);  // 此处易错
    count += get(other);
    return count;
  }

  public static void main(String[] args) {
    NumberOf1Between1AndN obj = new NumberOf1Between1AndN();

    final int N = 300;
    final int actual = obj.get(N);
    final int expected = obj.getUsingString(N);
    System.out.println(actual);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  int getUsingString(int N) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      String s = "" + i;
      IntStream intStream = s.chars().filter(c -> c == '1').map(c -> 1);
      count += intStream.count();
    }
    return count;
  }

}
