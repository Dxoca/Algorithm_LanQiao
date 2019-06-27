package org.lanqiao.algo.elementary._11_tree;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BSTPlusTest {
  BSTPlus tree = new BSTPlus();

  @Before
  public void init() {
    tree.insert(4, "4");
    tree.insert(1, null);
    tree.insert(10, null);
    tree.insert(14, null);
    tree.insert(7, "heiheihei");
    tree.insert(16, null);
    tree.insert(9, null);
    tree.insert(3, null);
    tree.insert(5, null);
    tree.insert(2, null);
    tree.insert(20, null);
    tree.insert(25, null);
    System.out.println(tree);
  }

  @Test
  public void numOfLeaf() throws Exception {
    assertThat(tree.numOfLeaf()).isEqualTo(4);
  }

  @Test
  public void numOfLevel() throws Exception {
    assertThat(tree.numOfLevel(3)).isEqualTo(3);
  }

  @Test
  public void isComplete() throws Exception {
    tree = new BSTPlus();
    tree.insert(50, "4");
    tree.insert(25, null);
    tree.insert(75, null);
    assertThat(tree.isComplete()).isTrue();
    tree.insert(40, null);
    assertThat(tree.isComplete()).isFalse();
    tree.insert(12, null);
    assertThat(tree.isComplete()).isTrue();
    tree.insert(60, null);
    tree.insert(80, null);
    assertThat(tree.isComplete()).isTrue();
    tree.insert(90, null);
    assertThat(tree.isComplete()).isFalse();
  }

  @Test
  public void search() throws Exception {
    tree.search(9, 16);
    System.out.println(tree.l);
  }
}