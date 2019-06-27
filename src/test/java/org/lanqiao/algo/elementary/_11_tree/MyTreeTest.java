package org.lanqiao.algo.elementary._11_tree;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MyTreeTest {
  MyTree<String> tree = new MyTree<>(new TreeNode("a"));

  @Before
  public void insertChild() throws Exception {
    TreeNode<String> root = tree.getRoot();
    TreeNode<String> b = new TreeNode<>("b");
    tree.insertChild(root, b);
    TreeNode<String> c = new TreeNode<>("c");
    tree.insertChild(root, c);
    TreeNode<String> d = new TreeNode<>("d");
    tree.insertChild(root, d);

    TreeNode<String> e = new TreeNode<>("e");
    tree.insertChild(b, e);
    tree.insertChild(b, new TreeNode<>("f"));
    tree.insertChild(c, new TreeNode<>("g"));
    tree.insertChild(d, new TreeNode<>("h"));

    TreeNode<String> i = new TreeNode<>("i");
    tree.insertChild(e, i);

    tree.insertChild(i, new TreeNode<String>("j"));

  }

  @Test
  public void getSize() throws Exception {
    Assertions.assertThat(tree.getSize()).isEqualTo(10);
  }

  @Test
  public void getRoot() throws Exception {
    Assertions.assertThat(tree.getRoot().key).isEqualTo("a");
  }

  @Test
  public void getParent() throws Exception {
    Assertions.assertThat(tree.getRoot().parent).isNull();
  }

  @Test
  public void getFirstChild() throws Exception {
    TreeNode<String> root = tree.getRoot();
    String key = tree.getFirstChild(root).key;
    Assertions.assertThat(key).isEqualTo("b");
  }

  @Test
  public void getNextSibling() throws Exception {
    TreeNode<String> root = tree.getRoot();
    String key = tree.getNextSibling(tree.getFirstChild(root)).key;
    Assertions.assertThat(key).isEqualTo("c");
  }

  @Test
  public void getHeight() throws Exception {
    Assertions.assertThat(tree.getHeight()).isEqualTo(4);
  }


  @Test
  public void deleteChild() throws Exception {
  }

  @Test
  public void preOrder() throws Exception {
  }

  @Test
  public void postOrder() throws Exception {
  }

  @Test
  public void levelOrder() throws Exception {
    List<List<TreeNode<String>>> lists = tree.levelOrder();
    for (List<TreeNode<String>> list :
        lists) {
      for (TreeNode<String> node : list) {
        System.out.print(node.key + "\t");
      }
      System.out.println("---");
    }
  }

}