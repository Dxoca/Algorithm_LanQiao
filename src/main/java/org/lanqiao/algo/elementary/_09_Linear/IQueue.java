package org.lanqiao.algo.elementary._09_Linear;

/**
 * 描述队列的基本操作
 * @author zhengwei lastmodified 2017年3月16日
 *
 */
public interface IQueue<T> {
  // 入队
  void enqueue(T e);

  // 出队
  T dequeue();

  //返回队列的大小
  int getSize();

  //判断队列是否为空
  boolean empty();

  //取队首元素
  T peek();
}
