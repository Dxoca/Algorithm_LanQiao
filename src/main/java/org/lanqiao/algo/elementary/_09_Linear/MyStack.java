package org.lanqiao.algo.elementary._09_Linear;

import org.lanqiao.algo.elementary._09_Linear.list.DoubleLinkedList;
import org.lanqiao.algo.elementary._09_Linear.list.ListNode;

import java.util.EmptyStackException;

public class MyStack<T> extends DoubleLinkedList<T> implements IStack<T> {
  @Override
  public void push(T e) {
    super.add(e);
  }

  @Override
  public T pop() {
    if (size <= 0) throw new EmptyStackException();
    ListNode<T> the = super.last.getPre();
    T res = the.getData();

    the.getPre().setNext(last);
    last.setPre(the.getPre());
    the.setNext(null);
    the.setPre(null);
    size--;
    return res;
  }

  @Override
  public boolean empty() {
    return getSize() == 0;
  }

  @Override
  public int getSize() {
    return super.getSize();
  }

  @Override
  public T peek() {
    return last.getPre().getData();
  }
}
