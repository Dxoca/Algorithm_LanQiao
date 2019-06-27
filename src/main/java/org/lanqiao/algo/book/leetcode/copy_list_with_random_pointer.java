package org.lanqiao.algo.book.leetcode;

import java.time.Instant;
import org.apache.commons.lang3.builder.EqualsBuilder;

/*A linked list is given such that each node contains 
 * an additional random pointer which could point to any 
 * node in the list or null.
 * Return a deep copy of the list.
*/
class RandomListNode {
  int label;
  RandomListNode next, random;

  public int getLabel() {
    return label;
  }

  public RandomListNode(int x) {
    this.label = x;
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, "next", "random");
  }
};

public class copy_list_with_random_pointer {

  public RandomListNode copyRandomList(RandomListNode head) {
    long now = Instant.now().toEpochMilli();
    if (head == null) {
      return null;
    }
    copyLabelAndInsertAll(head);
    dealRandom(head);
    RandomListNode result = removeOrigin(head);
    System.out.println((Instant.now().toEpochMilli() - now) / 1000);
    return result;

  }
  /**
   * 移除奇数位上的节点
   * @param head
   * @return
   */
  private RandomListNode removeOrigin(RandomListNode head) {
    head = head.next;
    RandomListNode p = head;
    while (p.next != null) {
      p.next = p.next.next;
      p = p.next;
    }
    return head;
  }

  /**
   * 处理每个节点的随机指针，当前节点的随机指针的下一个节点 
   * 是副本节点（下一节点）的随机指针指向
   * 
   * @param node
   */
  private void dealRandom(RandomListNode node) {
    do {
      if (node.random != null) {
        node.next.random = node.random.next;
      }
      node = node.next.next;
    } while (node != null); //~ 复制完成
  }

  /**
   * 拷贝每个节点的内容生成新的节点并插入到当前节点的后面 a->a->b->b...
   * 
   * @param node
   */
  private void copyLabelAndInsertAll(RandomListNode node) {
    do {
      /// 复制
      RandomListNode copyOf = copyOf(node);
      // 并追加
      copyOf.next = node.next;
      node.next = copyOf;
      node = copyOf.next; // 下一个需要复制的元素
    } while (node != null); //~ 复制完成
  }

  private RandomListNode copyOf(RandomListNode scan) {
    return new RandomListNode(scan.label);
  }
}
