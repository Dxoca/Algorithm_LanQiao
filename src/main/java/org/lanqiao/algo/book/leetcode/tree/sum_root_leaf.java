package org.lanqiao.algo.book.leetcode.tree;

import org.junit.Test;
import org.lanqiao.algo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree containing digits from0-9only,
each root-to-leaf path could represent a number.

An example is the root-to-leaf path1->2->3which represents the number123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.

Return the sum = 12 + 13 =25.*/
public class sum_root_leaf {

  public int sumNumbers(TreeNode<Integer> root) {
    if (root == null) return 0;
    f("", root);
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += Integer.parseInt(list.get(i));
    }
    return sum;
  }

  List<String> list = new ArrayList<String>();

  /**
   * 带前缀的dfs
   * @param pre
   * @param node
   */
  void f(String pre, TreeNode<Integer> node) {
    String _pre = pre + node.val;//将当前节点的值，附加到pre上面
    if (node.left == null && node.right == null) {//当前节点是叶子，结算
      list.add(_pre);
      return;
    }
    if (node.left != null)
      f(_pre, node.left);
    if (node.right != null)
      f(_pre, node.right);
  }

  @Test
  public void t() {
    sum_root_leaf obj = new sum_root_leaf();
    TreeNode<Integer> root = new TreeNode<>(1);
    TreeNode<Integer> l = new TreeNode<>(2);
    TreeNode<Integer> ll = new TreeNode<>(4);
    TreeNode<Integer> lr = new TreeNode<>(7);
    TreeNode<Integer> r = new TreeNode<>(3);
    TreeNode<Integer> rr = new TreeNode<>(5);
    TreeNode<Integer> rl = new TreeNode<>(8);
    root.left = l;
    root.right = r;
    l.left = ll;
    l.right = lr;
    r.right = rr;
    r.left = rl;
    int sum = obj.sumNumbers(root);
    System.out.println(sum);
  }

}
