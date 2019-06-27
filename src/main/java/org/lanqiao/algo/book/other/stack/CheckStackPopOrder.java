package org.lanqiao.algo.book.other.stack;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Preconditions;

import java.util.Stack;

/*
* ⭐️⭐️
* 检查B序列是否是压栈A序列的某个弹出顺序
* 仔细区分两种情况该继续，哪种情况为检验失败*/
public class CheckStackPopOrder {
  boolean check(int[] pushOrder, int[] popOrder) {
    Preconditions.checkArgument(pushOrder.length == popOrder.length, "两个序列的长度需一致");
    Stack<Integer> stack = new Stack<>();
    int p1 = 0;
    int p2 = 0;
    while (p2 != popOrder.length) {
      //栈顶和下一个计划出栈的元素不同
      if (stack.empty() || stack.peek() != popOrder[p2]) {
        // 已经没有可以压栈的元素，说明无法匹配
        if (p1 == pushOrder.length) {
          return false;
        } else {
          // 压入一个元素,直到栈顶和待出相等
          stack.push(pushOrder[p1++]);
        }
      } else {
        stack.pop(); // 相等就弹出
        p2++;
      }

    }
    return true;
  }

  public static void main(String[] args) {
    final CheckStackPopOrder obj = new CheckStackPopOrder();
    int[] pushOrder = {1, 2, 3, 4, 5};
    int[] popOrder = {4, 5, 3, 2, 1};
    boolean result = obj.check(pushOrder, popOrder);
    Assertions.assertThat(result).isTrue();
    pushOrder = new int[]{1, 2, 3, 4, 5};
    popOrder = new int[]{1, 2, 3, 4, 5};
    result = obj.check(pushOrder, popOrder);
    Assertions.assertThat(result).isTrue();
    pushOrder = new int[]{1, 2, 3, 4, 5};
    popOrder = new int[]{4, 5, 3, 1, 2};
    result = obj.check(pushOrder, popOrder);
    Assertions.assertThat(result).isFalse();
  }
}
