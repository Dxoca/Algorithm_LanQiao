package org.lanqiao.algo.util;

import org.junit.Test;

import java.util.Arrays;

public class UtilTest {
  @Test
  public void testPartition3() {
    int[] arr = {1, 3, 11, 45, 2, 10, 5, 6, 9};
    Util.print(arr);
    System.out.println();
    int[] pos = Util.partition3(arr, 0, arr.length - 1, 20);
    Util.print(arr);
    Util.print(pos);
  }

  @Test
  public void getMedian() {
    int[] arr = {1, 3, 11, 45, 2, 10, 5, 6, 9};
    int median = Util.getMedian(arr, 0, arr.length - 1);
    System.out.println(median);
    Arrays.sort(arr);
    Util.print(arr);
  }

  @Test
  public void ex() {
    System.out.println(Util.ex(2, 10));
  }
}