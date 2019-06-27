package org.lanqiao.algo.elementary._02searchAndSort;

import org.assertj.core.api.Assertions;
import org.lanqiao.algo.util.Util;
/**
 * 希尔排序是插入排序的一种。<br/>
 * 也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法<br/>
 *<br/>
 * 思路：如序列 9 8 7 6 5 4 3 2 1<br/>
 *      确定一个增量序列，如 4(length/2) 2 1 ，从大到小使用增量<br/>
 *      使用第一个增量，将序列划分为若干个子序列，下标组合为0-4-8，1-5,2-6,3-7<br/>
 *      依次对子序列使用直接插入排序法；<br/>
 *      使用第二个增量，将序列划分为若干个子序列(0-2-4-6-8),(1-3-5-7)<br/>
 *      依次对子序列使用直接插入排序法：<br/>
 *      使用第三个增量1，这时子序列就是元序列（0-1-2-3-4-5-6-7-8），使用直接插入法<br/>
 *      完成排序。<br/>
 * 时间复杂度：不太确定在O（nlogn）～O（n²）之间<br />
 * 空间复杂度：O(1)<br />
 * 原址排序<br />
 * 稳定性：由于相同的元素可能会被划分至不同子序列单独排序，因此稳定性是无法保证的——不稳定<br />
 *
 * */
public class _4ShellSort {
  public static void main(String[] args) {
    int[] arr = {9, 9, 6, 7, 5, 4, 2, 2, 1};
    shellSort(arr);
    Util.print(arr);
  }

  public static void shellSort(int[] arr) {
    //不断地缩小增量
    for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
      //增量为interval的插入排序
      for (int i = interval; i < arr.length; i++) {
        int target = arr[i];
        int j = i - interval;
        while (j > -1 && target < arr[j]) {
          arr[j + interval] = arr[j];
          j -= interval;
        }
        arr[j + interval] = target;
      }
    }
  }
}
