package org.lanqiao.algo.book.cc150;

import org.junit.Test;
import org.lanqiao.algo.TreeNode;

import static org.assertj.core.api.Java6Assertions.assertThat;

/*
public class TreeNode {
    int data = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int data) {
        this.data = data;
    }
}*/
/*
请实现一个函数，检查一棵二叉树是否为二叉查找树。
给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。

<思路>
中序遍历，全局变量记录上一个值，当前值必须大于上一个值
满足条件更新pre为当前值
* */
public class _4_5CheckBST2 {
  public boolean checkBST(TreeNode<Integer> root) {
    if (root == null)
      return true;

    //检查左子树，如果左子非bst立即返回false
    boolean leftIsBST = checkBST(root.left);
    if (!leftIsBST)
      return false;
    //根的值小于等于左子树的最大值，返回false
    if (root.val <= preValue) {
      return false;
    }
    //更新最后访问的值，检查右子树
    preValue = root.val;
    return checkBST(root.right);
  }

  private int preValue = Integer.MIN_VALUE;


  @Test
  public void test1() {
    TreeNode<Integer> root = new TreeNode(9);
    root.left = new TreeNode(2);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(28);
    // root.right.left.left = new TreeNode(8);
    root.right.left.left = new TreeNode(10);
    root.right.left.right = new TreeNode(16);
    root.right.right.left = new TreeNode(25);
    root.right.right.right = new TreeNode(29);
    assertThat(new _4_5CheckBST2().checkBST(root)).isTrue();
  }

  @Test
  public void test2() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(3);
    assertThat(new _4_5CheckBST2().checkBST(root)).isFalse();
  }


}