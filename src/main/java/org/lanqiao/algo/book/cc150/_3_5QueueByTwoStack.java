package org.lanqiao.algo.book.cc150;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class _3_5QueueByTwoStack {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void enqueue(int node) {
    if (stack1.isEmpty()) {
      move(stack2, stack1);
    }
    stack1.push(node);
  }

  public int dequeue() {
    if (stack2.isEmpty())
      move(stack1, stack2);
    int result = stack2.pop();

    return result;
  }

  private void move(Stack source, Stack target) {
    while (!source.empty()) {
      target.push(source.pop());
    }
  }

  public static void main(String[] args) {
    _3_5QueueByTwoStack obj = new _3_5QueueByTwoStack();
    obj.enqueue(1);
    obj.enqueue(2);
    System.out.println(obj.dequeue());//1
    obj.enqueue(3);

    System.out.println(obj.dequeue());//2
    obj.enqueue(4);
    System.out.println(obj.dequeue());//3
    System.out.println(obj.dequeue());
    obj.enqueue(5);
    System.out.println(obj.dequeue());

  }
}
