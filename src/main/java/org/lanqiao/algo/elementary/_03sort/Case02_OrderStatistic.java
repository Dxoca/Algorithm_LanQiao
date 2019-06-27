package org.lanqiao.algo.elementary._03sort;

import org.assertj.core.api.Assertions;

/**
 * 求顺序统计位的元素，如第一小元素，最大元素，第二小元素，或在顺序统计中任意位置的数
 * @author zhengwei lastmodified 2017年3月12日
 *
 */
public class Case02_OrderStatistic {
  /**
   * 期望O(n)，最差O(n²)
   *
   * @param A
   *          数组
   * @param p
   *          开始下标
   * @param r
   *          结束小标
   * @param k
   *          求第k小元素（递增第k个元素）
   * @return
   */
  public static int selectK(int[] A, int p, int r, int k) {
    int q = _5QuickSort.partition2(A, p, r);//主元的下标
    int qK = q - p + 1;//主元是第几个元素
    if (qK == k) return A[q];
    else if (qK > k) return selectK(A, p, q - 1, k);
    else return selectK(A, q + 1, r, k - qK);
  }

  public static void main(String[] args) {
    int[] A = {3, 9, 7, 6, 1, 2};
    int k = selectK(A, 0, A.length - 1, 2);
    System.out.println(k);
    Assertions.assertThat(k).isEqualTo(2);

    k = selectK(A, 0, A.length - 1, 1);
    Assertions.assertThat(k).isEqualTo(1);
    k = selectK(A, 0, A.length - 1, 3);
    Assertions.assertThat(k).isEqualTo(3);
    k = selectK(A, 0, A.length - 1, 6);
    Assertions.assertThat(k).isEqualTo(9);
  }
}
