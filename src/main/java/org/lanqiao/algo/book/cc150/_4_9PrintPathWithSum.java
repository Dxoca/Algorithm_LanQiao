package org.lanqiao.algo.book.cc150;

import org.junit.Test;
import org.lanqiao.algo.TreeNode;

import java.util.ArrayList;

/*输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
public class _4_9PrintPathWithSum {
  ArrayList<ArrayList<Integer>> res = new ArrayList<>();

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode<Integer> root, int target) {
    if (root == null) return res;
    f(new ArrayList<Integer>(), root, target);
    res.sort((l1, l2) -> {
      return -l1.size() + l2.size();
    });
    return res;
  }

  void f(ArrayList<Integer> pre, TreeNode<Integer> node, int target) {
    ArrayList<Integer> _pre = new ArrayList<>();
    _pre.addAll(pre);
    _pre.add(node.val);

    if (node.left == null && node.right == null) {
      if (target - node.val == 0) {
        res.add(_pre);
      }
      return;
    }

    if (node.left != null)
      f(_pre, node.left, target - node.val);
    if (node.right != null) {
      f(_pre, node.right, target - node.val);
    }
  }

  @Test
  public void t() {
    _4_9PrintPathWithSum obj = new _4_9PrintPathWithSum();
    TreeNode<Integer> root = new TreeNode<>(1);
    TreeNode<Integer> l = new TreeNode<>(2);
    TreeNode<Integer> r = new TreeNode<>(3);
    TreeNode<Integer> ll = new TreeNode<>(8);
    TreeNode<Integer> lr = new TreeNode<>(6);
    TreeNode<Integer> rl = new TreeNode<>(7);
    TreeNode<Integer> rr = new TreeNode<>(4);
    TreeNode<Integer> lrl = new TreeNode<>(2);
    TreeNode<Integer> rrr = new TreeNode<>(2);
    TreeNode<Integer> rrrr = new TreeNode<>(1);
    root.left = l;
    root.right = r;
    l.left = ll;
    l.right = lr;
    r.right = rr;
    r.left = rl;
    lr.left = lrl;
    rr.right = rrr;
    rrr.right = rrrr;
    ArrayList<ArrayList<Integer>> lists = obj.FindPath(root, 11);
    for (ArrayList<Integer> list : lists
        ) {
      System.out.println(list);
    }
  }
}
