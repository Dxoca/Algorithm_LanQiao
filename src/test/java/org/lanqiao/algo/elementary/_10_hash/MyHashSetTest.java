package org.lanqiao.algo.elementary._10_hash;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyHashSetTest {
  MyHashSet<String> set = new MyHashSet<>();

  @Before
  public void add() throws Exception {
    set.add("1");
    set.add("2");
    set.add("3");
  }

  @Test
  public void remove() throws Exception {
    System.out.println(set);
    set.remove("1");
    System.out.println(set);
    Assertions.assertThat(set.size()).isEqualTo(2);
  }

  @Test
  public void clear() throws Exception {
    set.clear();
    System.out.println(set);
  }

  @Test
  public void contains() throws Exception {
    Assertions.assertThat(set.contains("1")).isTrue();
  }

  @Test
  public void isEmpty() throws Exception {
    Assertions.assertThat(set.isEmpty()).isFalse();
  }

  @Test
  public void iter() throws Exception {
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }


}