package org.lanqiao.algo.elementary._09_Linear.list;

/*节点*/
public class ListNode<T> {
  T data;
  ListNode<T> pre;
  ListNode<T> next;

  public ListNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public ListNode<T> getPre() {
    return pre;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  public void setPre(ListNode<T> pre) {
    this.pre = pre;
  }

  public ListNode<T> getNext() {
    return next;
  }
}
