package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.TreeNode;
import org.lanqiao.algo.TreeUtil;

import java.util.Stack;

/**
 * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 *
 */
/*有parent的解法*/
public class _4_6Successor0 {
  public TreeNode<Integer> findSuccessor(TreeNode<Integer> node) {
    if (node == null)
      return null;
    if (null != node.right) {
      return minOfRight(node.right);
    } else {
      TreeNode<Integer> p = node;
      while (p.parent != null && p == p.parent.right) {
        p = p.parent;
      }
      return p.parent;
    }
  }

  private TreeNode<Integer> minOfRight(TreeNode<Integer> right) {
    TreeNode<Integer> p = right;
    while (p.left != null)
      p = p.left;
    return p;
  }

}
