package org.lanqiao.algo.book.other.stack;

import java.util.Stack;

/**
 * 难度：⭐⭐⭐⭐ <br>
 * 反转一个栈，不能用别的数据结构,不能用辅助空间，只能用递归
 *
 * @author zhengwei
 */
public class StackReverser {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.toString());
    final StackReverser stackReverser = new StackReverser();
   /*
    stackReverser.getAndRemoveLast(stack);
    */
    stackReverser.reverse(stack);
    System.out.println(stack.toString());
  }

  void reverse(Stack<Integer> stack) {
    if (stack.empty())
      return;
    // 相当于抽掉栈的栈底元素
    int i = getAndRemoveLast(stack);
    //    先反转剩下的
    reverse(stack);
    //    再将抽掉的元素压回
    stack.push(i);
  }

  Integer getAndRemoveLast(Stack<Integer> stack) {
    // 弹出第一个
    Integer result = stack.pop();
    if (stack.empty()) {
      return result;
    }
    // 递归移除剩下的最后一个元素，当倒数第一个返回时，层层返回
    Integer last = getAndRemoveLast(stack);
    // 压入上一个元素
    stack.push(result);
    //    返回最后一个元素
    return last;
  }
}
