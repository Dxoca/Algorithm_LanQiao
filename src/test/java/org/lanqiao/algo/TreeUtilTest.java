package org.lanqiao.algo;

import org.junit.Before;
import org.junit.Test;

public class TreeUtilTest {
  TreeNode<Integer> tree = TreeUtil.buildTree(10, 5, 15);

  @Before
  public void buildTree() throws Exception {
    TreeNode<Integer> ll = TreeUtil.buildTree(2, 1, 3);
    tree.left.left = ll;
    TreeNode<Integer> rr = TreeUtil.buildTree(17, 16, 18);
    tree.right.right = rr;
  }

  @Test
  public void inorderPrint() throws Exception {
    TreeUtil.inorderIter(tree, TreeUtilTest::print);
    System.out.println();
    TreeUtil.inorderIterNoRecursion(tree, TreeUtilTest::print);
  }

  @Test
  public void prePrint() throws Exception {
    TreeUtil.preIter(tree);
    System.out.println();
    TreeUtil.preIterNoRecursion(tree);
  }

  private static void print(Object o) {
    System.out.print(o + "\t");
  }
}