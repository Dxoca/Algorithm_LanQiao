package org.lanqiao.sort;

import org.junit.Test;
import org.lanqiao.algo.elementary._03sort._10RadixSort;

import static org.assertj.core.api.Assertions.assertThat;

public class _10RadixSortTest {

  @Test
  public void testSortIntArray() {
    int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
    _10RadixSort.sort( arr );
    assertThat( arr ).containsExactly( 14, 22, 28, 39, 43, 55, 65, 73, 81, 93 );

    arr = new int[]{456, 222, 2, 32, 211, 1234,9999};
    _10RadixSort.sort( arr );
    assertThat( arr ).containsExactly( 2, 32, 211, 222, 456, 1234,9999 );

    arr = new int[]{10, 30, 40, 70, 60, 1000,9009};
    _10RadixSort.sort( arr );
    assertThat( arr ).containsExactly( 10, 30, 40, 60, 70, 1000,9009 );
  }
}
