package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.elementary._09_Linear.IStack;
import org.lanqiao.algo.elementary._09_Linear.MyStack;
import org.lanqiao.algo.elementary._09_Linear.list.DoubleLinkedList;
import org.lanqiao.algo.elementary._09_Linear.list.ListNode;

import java.util.EmptyStackException;

public class _3_2StackWithMin extends DoubleLinkedList<Integer> implements IStack<Integer> {
  @Override
  public void push(Integer e) {
    super.add(e);
    if (brother.empty()) {
      brother.push(e);
    } else {
      Integer peek = brother.peek();
      if (e < peek) {
        brother.push(e);
      } else {
        brother.push(peek);
      }
    }
  }

  @Override
  public Integer pop() {
    if (size <= 0) throw new EmptyStackException();
    ListNode<Integer> the = super.last.getPre();
    Integer res = the.getData();

    the.getPre().setNext(last);
    last.setPre(the.getPre());
    the.setNext(null);
    the.setPre(null);
    size--;
    brother.pop();
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
  public Integer peek() {
    return last.getPre().getData();
  }

  private MyStack<Integer> brother = new MyStack<>();

  public int min() throws Exception {
    // ListNode<T> h = first.getNext();
    // int min = -1;
    // while(h!=last){
    //   if ((int)(h.getData())<min){
    //     min = (int)(h.getData());
    //   }
    // }
    // return min;
    if (!brother.empty())
      return brother.peek();
    else
      throw new Exception("没有元素了");
  }

  public static void main(String[] args) throws Exception {
    _3_2StackWithMin stack = new _3_2StackWithMin();
    stack.push(2);
    stack.push(9);
    stack.push(3);
    stack.push(1);
    stack.push(5);

    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
  }
}
