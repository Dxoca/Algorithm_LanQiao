package org.lanqiao.algo.elementary.digit;

import java.util.stream.IntStream;

public class NumberOfDigit {
  public static void main(String[] args) {
    NumberOfDigit app = new NumberOfDigit();
    System.out.println(app.countOfSevenIn9999());
    System.out.println(app.countOfNumNo3In999999());

    for (int i = 0; i < 3; i++) {
      System.out.println(Math.random());
    }
  }

  /**
   * 0-9999这一万个数按顺序摆放的话，里面会出现多少次字符7<br/>
   * 0000<br/>
   * 0001<br/>
   * ....<br/>
   * 9999<br/>
   * 一共一万行，第一列10个数字等概率出现，7的个数为总数的十分之一，即1000，<br/>
   * 同理第二列中的7是1000个，第三列、第四列分别为1000个，总数为4000个<br/>
   *
   * 下面是代码验证<br/>
   * @return
   */
  public int countOfSevenIn9999() {
    int count = 0;
    for (int i = 0; i < 10000; i++) {
      String s = "" + i;
      IntStream intStream = s.chars().filter(c -> c == '7').map(c -> 1);
      count += intStream.count();
    }
    return count;
  }

  /**
   * 0-999999之间的所有整数数字中（含0和999999），任何一位都不包括数字3的数字总数有多少<br>
   * 条件概率：第一位不为3有9种选择，第二位也是9位，……共9*9*9*9*9*9=9^6
   * @return
   */
  public int countOfNumNo3In999999() {
    int count = 0;
    for (int i = 0; i < 1000000; i++) {
      String s = "" + i;
      if (!s.contains("3")) {
        count++;
      }
    }
    return count;
  }
}
