package org.lanqiao.algo.elementary.digit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找素数中的等差数列<br />
 * 素数等差数列是等差数列的一种。在等差数列中，任何相邻两项的差相等。<br />
 * 该差值称为公差。类似“7、37、67、97、127、157”这样完全由素数组成的等差数列叫做素数等差数列。<br/>
 *
 *
 * 蓝桥杯 04/08/2017
 * 在小于10的素数中有3、5、7组成的等差数列，在小于30的素数中有11、17、23、29组成的等差数列。<br/>

 　　试找出区间[100,1000]内的素数构成的最大等差数列（即等差数列包含的素数个数最多）并打印输出。
 */
public class PrimeSequence {
  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    putPrimeInList(100, 300, list); //
    System.out.println(list);
    int count = 1;
    int max = count;
    int lastOne = 0;
    int thePublic=0;
    for (int gongchang = 30; gongchang < 900; gongchang++) { // 负责迭代公差
      for (int pre = 0; pre < list.size(); pre++) {  // 定位起始元素
        int from = pre;
        for (int next = from+1; next < list.size(); next++) { // 扫描后续元素
          if (list.get(next) - list.get(from) > gongchang) { // 断掉
            if (count > max) {
              max = count;
              lastOne = from;
              thePublic=gongchang;
            }
            count = 1; // 重置
            break;
          } else if (list.get(next) - list.get(from) < gongchang) {
          } else {
            count++;
            from = next;
          }

        }
        if (count > max) {
          max = count;
          lastOne = from;
          thePublic=gongchang;
        }
        count = 1; // 重置
      }
    }
    System.out.println("公差序列元素个数："+max);
    System.out.println("序列的最后一个元素："+list.get(lastOne));
    System.out.println("公差是："+thePublic);

    for (int i = 0; i < max; i++) {
      System.out.println(list.get(lastOne)-i*thePublic);
    }
  }


  /**
   * 筛选法求一定范围内的素数，并放入list
   * @param from 起始范围
   * @param  to  结束范围
   * @param  list 存放素数的列表
   */
  public static void putPrimeInList(int from, int to, List<Integer> list) {
    boolean[] arr = new boolean[to + 1];
    Arrays.fill(arr, true);
    arr[0] = false;
    arr[1] = false;

    for (int i = 4; i <= to; i = i + 2) {
      arr[i] = false;
    }
    for (int i = 3; i < Math.sqrt(to); i++) { // i代表素数
      if (arr[i]) {
        for (int j = 2; j * i <= to; j++) { // j为倍数
          arr[j * i] = false;
        }
      }
    }
    for (int i = from; i <= to; i++) {
      if (arr[i]) {
        list.add(i);
      }
    }
  }
}
