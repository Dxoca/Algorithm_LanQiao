package org.lanqiao.algo.elementary._09_Linear.list;

import java.util.Iterator;

/**
 * 线性表（列表）的接口定义
 */
public interface MyList<T> extends Iterator<T> {
  /**新增一个元素*/
  void add(T element);

  /**删除相同元素*/
  void delete(T element);

  /**根据索引删除元素*/
  void delete(int index);

  /**
   * 将指定索引位置的元素替换成新元素
   * @param index
   * @param newElement
   */
  void update(int index, T newElement);

  /**
   * 当前列表中是否含有target这个元素
   * @param target
   * @return
   */
  boolean contains(T target);

  /**
   * 返回指定索引处的元素
   * @param index
   * @return
   */
  T at(int index);

  /**
   * 查找element的索引，如果没有返回-1
   * @param element
   * @return
   */
  int indexOf(T element);

}
