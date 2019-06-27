package org.lanqiao.algo.book.cc150;


import java.util.HashSet;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头结点
 *
 * 有环链表的定义：
 * 在链表中某个结点的next元素指向在它前面出现过的节点，则表明该链表存在环路
 * */
public class _2_6_CircleLinkedList {

  public ListNode check(ListNode head) {
    ListNode p = head;
    HashSet set = new HashSet();
    while (true) {
      if (set.contains(p)) return p;
      else {
        set.add(p);
        p = p.next;
      }
    }
  }

  public boolean hasCircle(ListNode head) {
    ListNode s = head;
    ListNode f = head;
    while (true) {
      s = s.next;
      f = f.next.next;
      if (s == f)
        return true;
      if (f.next == null)
        return false;
    }
  }

  public ListNode beginOfCircle(ListNode head) {
    ListNode s = head;
    ListNode f = head;
    while (f != null && f.next != null) {
      s = s.next;
      f = f.next.next;
      if (s == f)
        break;
    }
    //何种方式退出的？
    if (f != null || f.next != null) {
      return null;
    }
    ListNode p = head;
    while (p != s) {
      p = p.next;
      s = s.next;
    }
    return p;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    ListNode begin = new ListNode(32);
    node.next.next = begin;
    node.next.next.next = new ListNode(32);
    node.next.next.next.next = new ListNode(2);
    node.next.next.next.next.next = begin;
    _2_6_CircleLinkedList obj = new _2_6_CircleLinkedList();
    // ListNode res = obj.check(node);
    // System.out.println(res.data);

    System.out.println(obj.hasCircle(node));
    System.out.println(obj.beginOfCircle(node).val);
  }
}
