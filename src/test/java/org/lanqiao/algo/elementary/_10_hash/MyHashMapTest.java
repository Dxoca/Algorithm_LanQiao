package org.lanqiao.algo.elementary._10_hash;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

public class MyHashMapTest {
  MyHashMap<String, Integer> map = new MyHashMap();

  @Before
  public void put() throws Exception {
    // 初始化随机种子
    Random r = new Random();
    map.put("one", 5);
    map.put("one", 10);
    map.put("two", 1);
    map.put("three", 2);
    // System.out.println(map);
  }

  @Test
  public void containsKey() throws Exception {
    Assertions.assertThat(map.containsKey("one")).isTrue();
    Assertions.assertThat(map.containsKey("two")).isTrue();
    Assertions.assertThat(map.containsKey("three")).isTrue();
    Assertions.assertThat(map.containsKey("four")).isFalse();
  }

  @Test
  public void containsValue() throws Exception {
    Assertions.assertThat(map.containsValue(10)).isTrue();
  }

  @Test
  public void get() throws Exception {
    Assertions.assertThat(map.get("three")).isEqualTo(2);
    Assertions.assertThat(map.get("four")).isNull();

  }

  @Test
  public void remove() throws Exception {
    Assertions.assertThat(map.remove("four")).isNull();
    Assertions.assertThat(map.remove("one")).isEqualTo(10);
    Assertions.assertThat(map.toString()).isEqualTo("(two,1),(three,2),");
    System.out.println(map);
  }

  @Test
  public void iterator() throws Exception {
    Iterator<MyHashMap.Node> iter = map.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}