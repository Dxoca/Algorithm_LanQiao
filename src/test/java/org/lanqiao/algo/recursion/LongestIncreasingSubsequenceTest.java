package org.lanqiao.algo.recursion;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.lanqiao.algo.lanqiaobei.programming.LongestIncreasingSubsequence;
import org.lanqiao.algo.util.Util;

public class LongestIncreasingSubsequenceTest {
  @Test
  public void indexOfBigger() throws Exception {
    final int i = Util.indexOfFirstBigger(new int[]{1, 4, 7, 9, 13}, 15, 0, 4);
    Assertions.assertThat(i).isEqualTo(-1);
  }

}