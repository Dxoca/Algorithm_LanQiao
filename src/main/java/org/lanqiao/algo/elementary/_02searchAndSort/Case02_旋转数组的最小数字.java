package org.lanqiao.algo.elementary._02searchAndSort;

import org.assertj.core.api.Assertions;

/**
 * 旋转数组的最小数字：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1.
 *
 * 考点：活用二分查找
 */
public class Case02_旋转数组的最小数字 {
  static int min(int[] arr) {
    int begin = 0;
    int end = arr.length - 1;
    //考虑没有旋转这种特殊的旋转
    if (arr[begin] < arr[end]) return arr[begin];

    //begin和end指向相邻元素，退出
    while (begin + 1 < end) {
      int mid = begin + ((end - begin) >> 1);

      //  要么左侧有序，要么右侧有序
      if (arr[mid] >= arr[begin]) {//左侧有序
        begin = mid;
      } else {
        end = mid;
      }
    }
    return arr[end];
  }

  public static void main(String[] args) {
    int[] arr = {5, 1, 2, 3, 4};
    int res = min(arr);
    Assertions.assertThat(res).isEqualTo(1);
    arr = new int[]{2, 3, 4, 5, 6};
    res = min(arr);
    Assertions.assertThat(res).isEqualTo(2);
    arr = new int[]{1, 0, 1, 1, 1};
    res = min(arr);
    Assertions.assertThat(res).isEqualTo(0);
  }

  /*测试下{10111}:{01111}的一个旋转*/
}
