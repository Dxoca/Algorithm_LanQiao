package org.lanqiao.algo.book.leetcode.tree;

import org.lanqiao.algo.TreeNode;

// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes
// along the shortest path
// from the root node down to the nearest leaf node.
public class MinDepth {
  public int run(TreeNode root) {
    if (root == null)
      return 0;
    int depLeft = run(root.left);
    int depRight = run(root.right);
    if (depLeft == 0 || depRight == 0)
      return 1 + depLeft + depRight;
    return 1 + Math.min(depLeft, depRight);
  }
}
