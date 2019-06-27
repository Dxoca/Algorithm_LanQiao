package org.lanqiao.algo.elementary._02searchAndSort;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Preconditions;
import org.lanqiao.algo.util.Util;

/**
 * 思路：第一趟，选择所有元素中最小的，和第一位交换 <br />
 *      第二趟，选择第二位及以后所有元素中最小的，和第二位交换<br />
 *      ……<br />
 * 时间复杂度：O(n²)<br />
 * 空间复杂度：O(1)<br />
 * 原址排序<br />
 * 稳定性：考虑32211，第一趟标记最末1为最小→1(4)221(3)3;第二趟标记原下标3的1为最小→1(4)1(3)223<br />
 * 两个1的相对位置发生了变化，因此不稳定<br />
 */
public class _2SelectionSort {
  private static void sort(int[] arr, int low, int high) {
    Preconditions.checkArgument(low <= high, "参数不正确，请确认low<=high");
    Preconditions.checkNotNull(arr);
    for (int i = low; i < high; i++) {
      int min = i;
      for (int j = min + 1; j <= high; j++) {
        if (arr[min] > arr[j])
          min = j; // 覆盖
      }
      Util.swap(arr, i, min); // 交换
    }
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 3, 2, 1};
    sort(arr, 0, arr.length - 1);
    Assertions.assertThat(Util.arrayToString(arr)).isEqualTo("123456");
    arr = new int[]{1};
    sort(arr, 0, arr.length - 1);
    Assertions.assertThat(Util.arrayToString(arr)).isEqualTo("1");
  }


}
