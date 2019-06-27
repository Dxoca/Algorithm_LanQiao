package org.lanqiao.algo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.lanqiao.algo.util.RMQ;

public class RMQTest {

  @Test
  public void dealRminq() throws Exception {
    int[] A = {1, 2, 3, 1, 4, 6, 3, 7, 0};
    RMQ.Result res = RMQ.deal(A);
    int min_0_7 = res.minQ(0, 7);
    assertThat(min_0_7).isEqualTo(1);
    int min_4_6 = res.minQ(4, 6);
    assertThat(min_4_6).isEqualTo(3);

    int min_0_8 = res.minQ(0, 8);
    assertThat(min_0_8).isEqualTo(0);
    int max_0_8 = res.maxQ(0, 8);
    assertThat(max_0_8).isEqualTo(7);
  }

}