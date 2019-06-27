package org.lanqiao.algo.book.cc150;

import org.assertj.core.api.Assertions;

/*有两个用链表表示的整数，每个结点包含一个数位。
这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
测试样例：
{1,2,3},{3,2,1}
返回：{4,4,4}

{7,4,0,7,5},{2,7,2,3,4}
返回：{9,1,3,0,0,1}
*/
public class _2_5PlusLinkNode {
  public ListNode plusAB(ListNode a, ListNode b) {
    return plusAB(a, b, 0);
  }
  private ListNode plusAB(ListNode a, ListNode b, int i) {
    if (a == null && b == null && i == 0)
      return null;
    int value = i;
    if (a != null)
      value += a.val;
    if (b != null)
      value += b.val;
    ListNode result = new ListNode(value % 10);
    result.next = plusAB(a == null ? null : a.next,
        b == null ? null : b.next,
        value >= 10 ? 1 : 0);
    return result;
  }

  private class NodeAndValue {
    ListNode node;
    boolean flag;

    public NodeAndValue(ListNode node, boolean flag) {
      this.node = node;
      this.flag = flag;
    }

    @Override
    public String toString() {
      return "NodeAndValue{" +
          "node=" + (flag ? "1" : "") + node.toString() +
          ", flag=" + flag +
          '}';
    }
  }

  //此处不考虑a,b长度不一样
  //如果不一样，先补齐
  private NodeAndValue plusAB1(ListNode a, ListNode b) {
    if (a.next == null && b.next == null) {
      int v = a.val + b.val;
      return new NodeAndValue(new ListNode(v % 10), v >= 10);
    }

    NodeAndValue other = plusAB1(a.next, b.next);
    int v;
    if (other.flag) {
      v = a.val + b.val + 1;
    } else {
      v = a.val + b.val;
    }
    if (v >= 10) {
      v = v % 10;
      ListNode res = new ListNode(v);
      res.next = other.node;
      return new NodeAndValue(res, true);
    } else {
      ListNode res = new ListNode(v);
      res.next = other.node;
      return new NodeAndValue(res, false);
    }
  }

  public static void main(String[] args) {
    _2_5PlusLinkNode obj = new _2_5PlusLinkNode();

    ListNode node1 = new ListNode(7);
    node1.next = new ListNode(4);
    node1.next.next = new ListNode(0);
    node1.next.next.next = new ListNode(7);
    node1.next.next.next.next = new ListNode(5);
    System.out.println(node1);

    ListNode node2 = new ListNode(2);
    node2.next = new ListNode(7);
    node2.next.next = new ListNode(2);
    node2.next.next.next = new ListNode(3);
    node2.next.next.next.next = new ListNode(4);
    System.out.println(node2);

    ListNode result = obj.plusAB(node1, node2);
    System.out.println(result);
    NodeAndValue res = obj.plusAB1(node1, node2);
    System.out.println(res);

    Assertions.assertThat(result.toString()).isEqualTo("913001");
  }
}
