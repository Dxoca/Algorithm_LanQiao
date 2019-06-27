package org.lanqiao.algo.elementary._02searchAndSort;

import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/**
 插入排序算法：<br />
 思路：假设某元素之前的子序列有序，该元素如果大于子序列末端元素则可继续下一个元素；如果该元素小于子序列末端，则往前插入到指定位置<br />
      第一趟：第一个元素已经有序<br />
      第二趟：第二个元素往前插<br />
      第三趟：第三个元素往前两个元素插<br />
      ……<br />
 * 时间复杂度：O(n²)=1+2+3+...+n-1<br />
 * 空间复杂度：O(1)<br />
 * 原址排序<br />
 * 稳定性：由于是从后往前，后续元素如果存在前面相等的，无法越过，相对位置不会发生变化<br />
 */
public class _3InsertionSort {
  static void sort(int[] arr) {
    sort( arr, 0, arr.length - 1 );
  }

  public static void sort(int[] arr, int low, int high) {
    for (int j = low + 1; j <= high; j++) {
      int key = arr[j];
      int pre = j - 1;
      /*套路：大的元素往后移直到前方没有大的，这时插入待排元素*/
      while (pre >= low && arr[pre] > key) {
        arr[pre + 1] = arr[pre];
        pre--;
      }
      arr[pre + 1] = key;
    }
  }
 /*反向排序*/
  static void sortInverse(int[] arr, int low, int high) {
    for (int j = low + 1; j <= high; j++) {
      int key = arr[j];
      int pre = j - 1;
      /*只需颠倒一下符号即可*/
      while (pre >= low && arr[pre] < key) {
        arr[pre + 1] = arr[pre];
        pre--;
      }
      arr[pre + 1] = key;
    }
  }

  public static void main(String[] args) {
    int[] arr = Util.getRandomArr( 20, 1, 100 );
    System.out.println( "begin..." + Arrays.toString( arr ) );
    sort( arr );
    System.out.println( "final..." + Arrays.toString( arr ) );
  }
}