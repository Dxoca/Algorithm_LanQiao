package org.lanqiao.algo.book.cc150;

//输入一个链表，输出该链表中倒数第k个结点。
class ListNode {
  int val;
  ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(val+"");
    ListNode nnext = next;
    while (nnext != null) {
      sb.append(nnext.val);
      nnext = nnext.next;
    }
    return sb.toString();
  }
}

public class _2_2KthNode {
  // 特别要注意边界的问题
  public ListNode FindKthToTail(ListNode head, int k) {
    if (head == null || k <= 0)
      return null;
    ListNode p1 = head;
    ListNode p2 = head;
    int count = 0;
    while (p2 != null && count < k) {
      p2 = p2.next;
      count++;
    }
    if (count < k) {
      return null;
    }
    while (p2 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    // System.out.println(p1.data);
    return p1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    ListNode head = new ListNode(arr[0]);//哑元
    ListNode p = head;
    for (int i = 1; i < arr.length; i++) {
      p.next = new ListNode(arr[i]);
      p = p.next;
    }
    // System.out.println(head);
    _2_2KthNode obj = new _2_2KthNode();
    ListNode l1 = obj.FindKthToTail(head, 1);
    System.out.println("+++++" + l1.val);
    System.out.println("+++++" + obj.FindKthToTail(head, 2).val);
    System.out.println("+++++" + obj.FindKthToTail(head, 3).val);
    System.out.println("+++++" + obj.FindKthToTail(head, 4).val);
    System.out.println("+++++" + obj.FindKthToTail(head, 5).val);
    System.out.println("+++++" + obj.FindKthToTail(head, 6).val);

  }
  //5,{1,2,3,4,5}
}
