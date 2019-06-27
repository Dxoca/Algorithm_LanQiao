package org.lanqiao.algo.elementary._03sort;

import java.util.Arrays;
import java.util.Comparator;

public class Case11_MinCombineNum {
  public static void main(String[] args) {
    int res = f(new Integer[]{3, 32, 321});
    System.out.println(res);
  }

  private static int f(Integer[] arr) {
    //自定义比较规则
    Arrays.sort(arr, new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        String s1 = o1 + "" + o2;
        String s2 = o2 + "" + o1;
        return s1.compareTo(s2);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
    }
    return Integer.parseInt(sb.toString());
  }
}
