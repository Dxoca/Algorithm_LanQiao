package org.lanqiao.algo.recursion;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.lanqiao.algo.elementary._06_math.Case11_NExponent;
import org.lanqiao.algo.util.Util;

public class Case11NExponentTest {
  @Test
  public void ex() throws Exception {
    Assertions.assertThat(Case11_NExponent.ex(2, 10)).isEqualTo(1024);
  }

  @Test
  public void ex2() throws Exception {
    Assertions.assertThat(Case11_NExponent.ex2(2, 10)).isEqualTo(1024);
  }

  @Test
  public void matrixPower() throws Exception {
    long[][] res = Util.matrixMultiply(new long[][]{
        {2, 3},
        {4, 5}
    }, new long[][]{
        {1, 3},
        {2, 4}
    });
    Util.printMatrix(res);
  }

  @Test
  public void matrixMultiply() throws Exception {
    int n = 40;
    long[][] res = Util.matrixPower(new long[][]{
        {1, 1},
        {1, 0}
    }, n - 2);
    Util.printMatrix(res);
    long actual = res[0][0] + res[1][0];
    // actual=7778742049L+4807526976L;
    // Assertions.assertThat(actual).isEqualTo((int) Fibonacci.m2(n));
  }

}