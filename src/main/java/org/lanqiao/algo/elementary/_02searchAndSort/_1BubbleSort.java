package org.lanqiao.algo.elementary._02searchAndSort;

import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/**
 * 冒泡排序算法<br />
 * 思路：第一趟，通过两两交换的手段，将最大元素顶到最末端<br />
 *      第二趟，…………………………………………，将次大元素顶到倒数第二个位置<br />
 *      ……<br />
 * 时间复杂度：O(n²)<br />
 * 空间复杂度：O(1)<br />
 * 原址排序<br />
 * 稳定性：有相同元素，排序前和排序后相对位置不会变化，稳定<br />
 */
public class _1BubbleSort {
  static void sort1(int[] arr) {
    for (int j = 0; j < arr.length; j++) {
      //注意上边界，泡都从第一个开始冒，但是每一趟完成之后，天花板在降低
      for (int i = 0; i < arr.length - j - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          Util.swap(arr, i, i + 1);
        }
      }
    }
  }

  // 细微的改进
  static void sort2(int[] arr) {
    for (int j = 0; j < arr.length; j++) {
      //标记这一趟是不是有交换，如果没有交换，顺序就已经排好了
      boolean ordered = true;
      //注意上边界，泡都从第一个开始冒，但是每一趟完成之后，天花板在降低
      for (int i = 0; i < arr.length - j - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          Util.swap(arr, i, i + 1);
          ordered = false;
        }
      }
      if (ordered) {
        break;
      }
    }
  }


  public static void main(String[] args) {
    /*耗时,N * N ≈ 100000*100000 10的10次方 */
    int[] arr = Util.getRandomArr(100000, 1, 1000);
    // System.out.println("begin..." + Arrays.toString(arr));
    long now = System.currentTimeMillis();
    sort2(arr);//冒泡排序
    Util.duration(now);
    // System.out.println("final..." + Arrays.toString(arr));

    /*试试jdk的排序耗时,N*LgN ≈ 100000*17*/
    arr = Util.getRandomArr(100000, 1, 1000);
    now = System.currentTimeMillis();
    Arrays.sort(arr);
    Util.duration(now);
  }
}