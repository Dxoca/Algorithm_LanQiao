package org.lanqiao.algo.book.leetcode;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

public class copy_list_with_random_pointerTest {

  private static final int SIZE = 50;

  @Test
  public void testCopyRandomList() {
    RandomListNode[] arr = new RandomListNode[SIZE];
    for (int i = 0; i < SIZE; i++) {
      RandomListNode node = new RandomListNode(RandomUtils.nextInt());
      arr[i] = node;
    }
    for (int i = 0; i < SIZE - 1; i++) {
      arr[i].next = arr[i + 1];
      arr[i].random = arr[RandomUtils.nextInt(0, SIZE)];
    }
    
    RandomListNode result = new copy_list_with_random_pointer().copyRandomList(arr[0]);
    Assert.assertEquals(arr[0], result);
  }

}
