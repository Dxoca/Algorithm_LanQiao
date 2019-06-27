package org.lanqiao.algo.elementary._11_tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AVLTreeTest {
  IBinarySearchTree<Integer, String> tree = new AVLTree<Integer, String>();

  @Before
  public void insert() throws Exception {
    tree.insert(14, "4");
    tree.insert(11, null);
    tree.insert(20, null);
    tree.insert(24, null);
    tree.insert(17, null);
    tree.insert(26, null);
    assertThat(tree.isBalance()).isTrue();
    System.out.println(tree);
    System.out.println("------------");
    tree.insert(19, null);
    System.out.println(tree);
    System.out.println("------------");
    tree.insert(8, null);
    assertThat(tree.isBalance()).isTrue();
    tree.insert(15, null);//触发左右型
    assertThat(tree.isBalance()).isTrue();
    System.out.println(tree);
    System.out.println("------------");
    tree.insert(12, null);
    tree.insert(15, null);
    System.out.println(tree);
    System.out.println("------------");
    assertThat(tree.isBalance()).isTrue();
    // Random random = new Random();
    tree.insert(41, null);
    System.out.println(tree);
    System.out.println("------------");
    assertThat(tree.isBalance()).isTrue();
    tree.insert(58, null);
    System.out.println(tree);
    System.out.println("------------");
    assertThat(tree.isBalance()).isTrue();
    tree.insert(75, null);
    System.out.println(tree);
    System.out.println("------------");
    assertThat(tree.isBalance()).isTrue();
    tree.insert(85, null);
    assertThat(tree.isBalance()).isTrue();
    tree.insert(92, null);
    assertThat(tree.isBalance()).isTrue();
    tree.insert(48, null);
    assertThat(tree.isBalance()).isTrue();

  }

  @Test
  public void remove() {
    System.out.println(tree);
    tree.remove(19);
    System.out.println("------");
    System.out.println(tree);
    assertThat(tree.isBalance()).isTrue();
    tree.remove(20);
    System.out.println("------");
    System.out.println(tree);
    assertThat(tree.isBalance()).isTrue();
    tree.remove(24);
    System.out.println("------");
    System.out.println(tree);
    assertThat(tree.isBalance()).isTrue();
  }
  @Test
  public void testLdr() {
    tree.inorder(k -> {
      System.out.println(k);

    });

  }
}