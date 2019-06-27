package org.lanqiao.algo.elementary._09_Linear;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {
  MyStack<String> stack = new MyStack<>();

  @Before
  public void init() {
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");
  }


  @Test
  public void pop() throws Exception {
    assertEquals("d", stack.peek());
    assertEquals(stack.pop(), "d");
    assertEquals(stack.pop(), "c");
    assertEquals(stack.pop(), "b");
    assertEquals(stack.pop(), "a");
    assertEquals(stack.empty(), true);
    assertEquals(0, stack.getSize());
    // stack.dequeue();//Exception
  }


  @Test
  public void getSize() throws Exception {
    assertEquals(stack.getSize(), 4);
  }

}