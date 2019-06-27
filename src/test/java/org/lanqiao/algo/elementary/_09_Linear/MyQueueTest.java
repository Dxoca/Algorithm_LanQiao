package org.lanqiao.algo.elementary._09_Linear;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
  MyQueue<String> queue = new MyQueue<>();

  @Before
  public void enqueue() throws Exception {
    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");
  }

  @Test
  public void dequeue() throws Exception {
    Assertions.assertThat(queue.getSize()).isEqualTo(4);
    Assertions.assertThat(queue.peek()).isEqualTo("a");
    Assertions.assertThat(queue.dequeue()).isEqualTo("a");
    Assertions.assertThat(queue.peek()).isEqualTo("b");
    Assertions.assertThat(queue.dequeue()).isEqualTo("b");
    Assertions.assertThat(queue.dequeue()).isEqualTo("c");
    Assertions.assertThat(queue.dequeue()).isEqualTo("d");
    Assertions.assertThat(queue.empty()).isTrue();

  }

  @Test
  public void empty() throws Exception {
  }

  @Test
  public void peek() throws Exception {
  }

}