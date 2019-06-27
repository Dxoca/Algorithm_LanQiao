package org.lanqiao.algo.elementary._02searchAndSort;

import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/*
二分查找
*/
public class _0BinarySearch {

  private static int binarySearch0(int[] arr, int low, int high,
                                   int key) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);//(low + high) >>> 1;//防止溢出，移位也更高效。同时，每次循环都需要更新。
      int midVal = arr[mid];

      if (midVal < key)
        low = mid + 1;
      else if (midVal > key)
        high = mid - 1;
      else
        return mid; // key found
    }
    return -(low + 1); // key not found.
  }

  /*递归解法*/
  private static int binarySearch1(int[] arr, int low, int high, int key) {
    if (low > high)
      return -1;
    int mid = low + ((high - low) >> 1);//(low + high) >>> 1;//防止溢出，移位也更高效。
    int midVal = arr[mid];

    if (midVal < key)
      return binarySearch1(arr, mid + 1, high, key);
    else if (midVal > key)
      return binarySearch1(arr, low, high - 1, key);
    else
      return mid; // key found
  }

  /**
   * 顺序查找
   * @param arr
   * @param key
   * @return
   */
  private static int search(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] x = new int[10000 * 10000];
    for (int i = 0; i < x.length; i++) {
      x[i] = i + 1;
    }
    int target = 100000 * 10000;

    long now = System.currentTimeMillis();
    int index = binarySearch0(x, 0, x.length - 1, target);
    // Util.duration(now);
    System.out.println(System.currentTimeMillis() - now + "ms");

    System.out.println(target + "所在位置为：" + index);


    now = System.currentTimeMillis();
    //调用顺序查找
    index = search(x, target);
    Util.duration(now);

  }
}

