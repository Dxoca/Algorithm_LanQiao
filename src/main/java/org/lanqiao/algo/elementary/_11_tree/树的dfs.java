package org.lanqiao.algo.elementary._11_tree;

import org.lanqiao.algo.TreeNode;

public class 树的dfs {


  public static void main(String[] args) {
    TreeNode root = buildTree();

    // preOrder(root);
    // postOrder(root);
    inOrder(root);
  }

  /**
   * 中序
   * @param root
   */
  private static void inOrder(TreeNode root) {
    if (root == null)
      return;
    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);

  }

  /**
   * 后序遍历
   * */
  private static void postOrder(TreeNode n1) {
    if (n1 == null)
      return;
    postOrder(n1.left);
    postOrder(n1.right);
    System.out.println(n1.val);
  }

  /**
   * 先序遍历
   * @param n1
   */
  private static void preOrder(TreeNode n1) {
    if (n1 == null)
      return;

    System.out.println(n1.val);

    preOrder(n1.left);
    preOrder(n1.right);
  }

  private static TreeNode buildTree() {
    TreeNode n1 = new TreeNode<Integer>(1);
    TreeNode n2 = new TreeNode<Integer>(2);
    TreeNode n3 = new TreeNode<Integer>(3);
    TreeNode n4 = new TreeNode<Integer>(4);
    TreeNode n5 = new TreeNode<Integer>(5);
    TreeNode n6 = new TreeNode<Integer>(6);
    TreeNode n7 = new TreeNode<Integer>(7);
    TreeNode n8 = new TreeNode<Integer>(8);
    TreeNode n9 = new TreeNode<Integer>(9);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n4.left = n7;
    n5.left = n8;
    n3.right = n6;
    n6.right = n9;
    return n1;
  }
}
