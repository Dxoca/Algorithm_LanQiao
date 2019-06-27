package org.lanqiao.algo.book.cc150;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 示例：
 * 输入单向链表a->b->c->d->e中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e
 *
 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 */
public class _2_3RemoveNodeN1 {
  public boolean removeNode(ListNode pNode) {
    if (pNode.next == null)
      return false;
    pNode.val = pNode.next.val;//复制后继的内容
    pNode.next = pNode.next.next;//跨越后继
    return true;
  }
}
