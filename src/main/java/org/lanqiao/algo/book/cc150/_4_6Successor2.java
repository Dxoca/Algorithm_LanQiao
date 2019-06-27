package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.TreeNode;
import org.lanqiao.algo.TreeUtil;

/**
 * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。

 * 这个是中序遍历的递归套路
 */
public class _4_6Successor2 {
  public int findSucc(TreeNode root, int p) {
    if (root == null)
      return -1;
    in(root, p);
    return succ;
  }

  private void in(TreeNode<Integer> node, int p) {
    if (node == null)
      return;
    in(node.left, p);
    if (preValue == p) {
      if (succ != -1)
        return;
      succ = node.val;
      // System.out.println(succ);
      return;
    }
    preValue = node.val;
    in(node.right, p);
  }

  private int preValue = Integer.MIN_VALUE;
  private int succ = -1;

  public static void main(String[] args) {
    TreeNode root = TreeUtil.buildTree(8, 6, 10);
    root.left.left = TreeUtil.buildTree(3, 1, 4);
    root.right.right = TreeUtil.buildTree(13, 11, 15);
    root.right.left = new TreeNode(9);

    final _4_6Successor2 tool = new _4_6Successor2();
    System.out.println(tool.findSucc(root, 8));
  }
}
