package org.lanqiao.algo.elementary._09_Linear;


import org.lanqiao.algo.elementary._09_Linear.list.MyList;

/**
 * 描述栈的基本操作
 * @author zhengwei lastmodified 2017年3月16日
 *
 */
public interface IStack<T> {
  /**
   * 元素入栈
   * @param e
   */
  void push(T e);

  /**
   * 弹出栈顶（栈中无此元素）
   * @return
   */
  T pop();

  /**
   * 是否空栈
   * @return
   */
  boolean empty();

  /**
   * 栈内元素个数
   */
  int getSize();

  /**
   * 查看栈顶元素，不弹出
   * @return
   */
  T peek();
}
