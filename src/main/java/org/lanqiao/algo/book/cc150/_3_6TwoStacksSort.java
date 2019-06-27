package org.lanqiao.algo.book.cc150;

import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 测试样例：
 [1,2,3,4,5]
 返回：[5,4,3,2,1]
 */
public class _3_6TwoStacksSort {
  public static void main(String[] args) {
    _3_6TwoStacksSort obj = new _3_6TwoStacksSort();
    obj.twoStacksSort(new int[]{1, 2, 3, 4, 5});
  }

  public void twoStacksSort(int[] numbers) {
    // 初始化原始栈
    Stack<Integer> source = new Stack<>();
    for (int i = numbers.length - 1; i >= 0; i--) {
      source.push(numbers[i]);
    }

    Stack<Integer> target = twoStacksSort(source);
    while (!target.isEmpty()) {
      System.out.println(target.pop());
    }
  }

  public Stack<Integer> twoStacksSort(Stack<Integer> source) {

    Stack<Integer> target = new Stack<>();
    sortToTarget(source, target);

    return target;
  }

  private void sortToTarget(Stack<Integer> source, Stack<Integer> target) {
    while (!source.empty()) {
      int v1 = source.pop(); // 揭开盖子
      if (target.empty()) {
        target.push(v1);
      } else {
        int v2 = target.peek();
        if (v1 >= v2) {  // 盖子大，直接放入
          target.push(v1);
        } else {  // 盖子小，把大的先回收
          source.push(target.pop());
          // 直到有盖子的容身之所
          while (!target.empty() && v1 < target.peek()) {
            source.push(target.pop());
          }
          target.push(v1);
        }
      }
    }
  }
}
