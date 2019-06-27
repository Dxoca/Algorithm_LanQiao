package org.lanqiao.algo.elementary._02searchAndSort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.lanqiao.algo.elementary._03sort.Case02_OrderStatistic;
import org.lanqiao.algo.util.Util;

public class Case02OrderStatisticTest {

	@Test
	public void testRandomSelect() {
		int[] arr = new int[] { 2, 4, 5, 3, 1 };
		//  用12345，第三个顺序统计元素应该是arr[2]即3这个数
    assertThat(Case02_OrderStatistic.selectK(arr, 0, arr.length - 1, 1)).isEqualTo(1);
    assertThat(Case02_OrderStatistic.selectK(arr, 0, arr.length - 1, 2)).isEqualTo(2);
    assertThat(Case02_OrderStatistic.selectK(arr, 0, arr.length - 1, 3)).isEqualTo(3);
    assertThat(Case02_OrderStatistic.selectK(arr, 0, arr.length - 1, 4)).isEqualTo(4);
    assertThat(Case02_OrderStatistic.selectK(arr, 0, arr.length - 1, 5)).isEqualTo(5);
  }


	@Test
	public void testGetMedian() {
		int[] arr = { 32, 23, 12, 67, 45, 78, 10, 39, 9, 58, 125, 84 };// 中位数为39
		assertThat(Util.getMedian(arr, 0, arr.length)).isEqualTo(39);
	}


}
