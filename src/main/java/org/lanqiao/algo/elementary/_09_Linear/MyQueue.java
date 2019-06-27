package org.lanqiao.algo.elementary._09_Linear;

import org.lanqiao.algo.elementary._09_Linear.list.DoubleLinkedList;
import org.lanqiao.algo.elementary._09_Linear.list.ListNode;

public class MyQueue<T> extends DoubleLinkedList<T> implements IQueue<T> {
  @Override
  public void enqueue(T e) {
    super.add(e);
  }

  @Override
  public T dequeue() {
    ListNode<T> h = first.getNext();
    first.setNext(h.getNext());
    h.getNext().setPre(first);
    h.setPre(null);
    h.setNext(null);
    size--;
    return h.getData();
  }

  @Override
  public boolean empty() {
    return getSize() == 0;
  }

  @Override
  public T peek() {
    return first.getNext().getData();
  }
}
