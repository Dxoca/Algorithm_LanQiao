package org.lanqiao.algo.elementary.exercise;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.lanqiao.algo.elementary._03sort.Case12_ContainsAll;

public class Case12_ContainsAllTest {
  @Test
  public void check() throws Exception {
    boolean res = Case12_ContainsAll.check("abc", "dajdewifahjbc");
    Assertions.assertThat(res).isTrue();
  }

}