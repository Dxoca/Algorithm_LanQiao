package org.lanqiao.algo.elementary._09_Linear.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
  MyArrayList<String> list = new MyArrayList<String>();

  @Test
  @Before
  public void add() throws Exception {
    list.add("nike");
    list.add("addidiaos");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");
    list.add("NB");

    // list.add(10);
    System.out.println(list);
  }

  @Test
  public void delete() throws Exception {
    list.delete(2);
    list.delete(2);
    list.delete(2);
    list.delete(2);
    list.delete(2);
    list.delete(2);
    list.delete(2);
    list.delete(2);
    list.delete(2);
    System.out.println(list);
  }

  @Test
  public void delete1() throws Exception {
  }

  @Test
  public void update() throws Exception {
  }

  @Test
  public void contains() throws Exception {
  }

  @Test
  public void indexOf() throws Exception {
  }

  @Test
  public void iter() {
    while (list.hasNext()) {
      String next = list.next();
      System.out.println(next);
    }
  }
}