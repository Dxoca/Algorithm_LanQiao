package org.lanqiao.algo.elementary._09_Linear.list;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.algo.elementary._09_Linear._01_oop.Student;

import static org.junit.Assert.*;

public class SingleLinkedListTest {
  SingleLinkedList list = new SingleLinkedList();

  @Test
  @Before
  public void add() throws Exception {
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add(1);
    list.add(2);
    list.add(new Student("zhangsan", 10));
    list.add("e");
    // System.out.println(list);
  }

  @Test
  public void delete() throws Exception {
    list.delete("a");
    // System.out.println(list);
  }

  @Test
  public void delete1() throws Exception {
    list.delete(0);
    // System.out.println(list);
    Assertions.assertThat(list.toString()).isEqualTo("[b,c,d,e]");
    list.delete(2);
    Assertions.assertThat(list.toString()).isEqualTo("[b,c,e]");
    list.delete(0);
    list.delete(0);
    list.delete(0);
    list.delete(0);
    Assertions.assertThat(list.toString()).isEqualTo("[]");
  }

  @Test
  public void update() throws Exception {
    list.update(0, "x");
    Assertions.assertThat(list.toString()).isEqualTo("[x,b,c,d,e]");
    list.update(10, "x");
    Assertions.assertThat(list.toString()).isEqualTo("[x,b,c,d,e]");
  }

  @Test
  public void contains() throws Exception {
    Assertions.assertThat(list.contains("c")).isTrue();
    Assertions.assertThat(list.contains("y")).isFalse();
  }

  @Test
  public void at() throws Exception {
    Assertions.assertThat(list.at(0)).isEqualTo("a");
    Assertions.assertThat(list.at(1)).isEqualTo("b");
    Assertions.assertThat(list.at(2)).isEqualTo("c");
    Assertions.assertThat(list.at(3)).isEqualTo("d");
    Assertions.assertThat(list.at(4)).isEqualTo("e");
  }

  @Test
  public void indexOf() throws Exception {
    Assertions.assertThat(list.indexOf("c")).isEqualTo(2);
    Assertions.assertThat(list.indexOf("a")).isEqualTo(0);
    Assertions.assertThat(list.indexOf("x")).isEqualTo(-1);
  }

}