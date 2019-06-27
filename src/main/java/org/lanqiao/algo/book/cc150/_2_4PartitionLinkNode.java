package org.lanqiao.algo.book.cc150;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。

 注意：分割以后保持原来的数据顺序不变。

 不要开辟新的空间，即不要新建节点
 */

public class _2_4PartitionLinkNode {

  public ListNode partition(ListNode pHead, int x) {
    ListNode p = pHead;
    ListNode leftFirst = null;
    ListNode leftTail = null;
    ListNode rightFirst = null;
    ListNode rightTail = null;

    while (p != null) {//顺序扫描所有节点
      int pValue = p.val;
      if (pValue < x) {//小于x
        if (leftTail == null) {
          leftFirst = p;
          leftTail = p;
        } else {
          leftTail.next = p;
          leftTail = leftTail.next;
        }
      } else {//大于等于x
        if (rightTail == null) {
          rightFirst = p;
          rightTail = p;
        } else {
          rightTail.next = p;
          rightTail = rightTail.next;
        }
      }
      p = p.next;
    }
    if (leftFirst == null) {// 左边链表可能为空
      return rightFirst;
    }
    leftTail.next = rightFirst;//左右两个链表连接起来
    if (rightTail != null)
      rightTail.next = null;
    return leftFirst;
  }
}
