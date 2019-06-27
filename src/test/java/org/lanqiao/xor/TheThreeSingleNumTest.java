package org.lanqiao.xor;

import org.junit.Test;
import org.lanqiao.algo.elementary._01xor.exam.TheThreeSingleNum;

import static org.assertj.core.api.Assertions.*;

public class TheThreeSingleNumTest {

  @Test
  public void testGetLastBitIndexOf1() {
    assertThat(TheThreeSingleNum.getLastBitIndexOf1(0b1101_1000)).isEqualTo(3);
  }

  @Test
  public void testSaveLast1() {
    assertThat(TheThreeSingleNum.saveLast1(0b1101_1000)).isEqualTo(0b00001000);
  }

  @Test
  public void testFindTheThreeSingleNum() {
    assertThat(TheThreeSingleNum.findTheThreeSingleNum(new int[]{1, 2, 3, 4, 4, 5, 5, 6, 6})).containsOnly(1, 2, 3);
    assertThat(TheThreeSingleNum.findTheThreeSingleNum(new int[]{1, 2, 2, 4, 5, 5, 6, 6, 9})).containsOnly(1, 4, 9);
  }
}
