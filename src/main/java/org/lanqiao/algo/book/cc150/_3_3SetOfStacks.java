package org.lanqiao.algo.book.cc150;

import java.util.ArrayList;

/**
 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 该数据结构应支持与普通栈相同的push和pop操作。

 给定一个操作序列int[][2] ope，每个操作的第一个数代表操作类型，
 若为1，则为push操作，后一个数为应push的数字；
 若为2，则为pop操作，后一个数无意义。

 请返回一个int[][](C++为vector&ltvector&ltint>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。

 保证数据合法。
 */
public class _3_3SetOfStacks {
  public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> currStack = new ArrayList<Integer>(size);//正在操作的栈
    res.add(currStack);
    for (int[] opAndValue : ope) {
      int op = opAndValue[0];
      int value = opAndValue[1];

      if (op == 1) {
        if (currStack.size() == size) { // 当前满
          currStack = new ArrayList<Integer>(size);//创建一个新的栈
          res.add(currStack);
        }
        currStack.add(value);
      } else {//出栈
        if (currStack.size() == 0) {
          res.remove(currStack);//栈的列表中移除
          currStack = res.get(res.size() - 1);//被操作的栈是列表中的上一个栈
        }
        currStack.remove(currStack.size() - 1);
      }
    }
    return res;
  }
}
