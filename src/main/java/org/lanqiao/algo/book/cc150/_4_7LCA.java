package org.lanqiao.algo.book.cc150;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _4_7LCA {
  public int getLCA(int a, int b) {
    TreeNode<Integer> root = of(10);

    TreeNode<Integer> lca = getLCA2(root, new TreeNode<Integer>(a), new TreeNode<Integer>(b));
    return lca == null ? -1 : lca.val;
  }

  private TreeNode<Integer> getLCA(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
    if (root == null) return null;
    if (root.equals(p) || root.equals(q)) return root;

    boolean is_p_on_left = cover(root.left, p);
    boolean is_q_on_right = cover(root.right, q);
    if (is_p_on_left == is_q_on_right) {//在root的两端
      return root;
    } else if (is_p_on_left) {//在root的左端
      return getLCA(root.left, p, q);
    } else {
      return getLCA(root.right, p, q);
    }
  }

  private TreeNode<Integer> getLCA2(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
    if (root == null) return null;
    if (root.equals(p) && root.equals(q)) return root;

    TreeNode<Integer> x = getLCA2(root.left, p, q);//x是lca，或者是p（p在这一侧），或者是q（q在这一侧），或者是null（pq都不在这一侧）
    if (x != null && !x.equals(p) && !x.equals(q)) {//在左子树找到了lca
      return x;
    }

    TreeNode<Integer> y = getLCA2(root.right, p, q);
    if (y != null && !y.equals(p) && !y.equals(q)) {//在右子树找到了lca
      return y;
    }

    //  x：p,q,null y :q,p,null
    if (x != null && y != null) {//一边找着一个
      return root;
    } else if (root.equals(p) || root.equals(q)) {
      return root;
    } else {
      return x == null ? y : x;//有一个不为null，则返回，都为null，返回null
    }
  }

  /**
   * 判断x节点是否在n所代表的子树中
   * @param n
   * @param x
   * @return
   */
  private boolean cover(TreeNode<Integer> n, TreeNode<Integer> x) {
    if (n == null) return false;
    if (n.equals(x)) return true;
    return cover(n.left, x) || cover(n.right, x);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //发现目标节点则通过返回值标记该子树发现了某个目标结点
    if (root == null || root.equals(p.val) || root.equals(q)) return root;
    //查看左子树中是否有目标结点，没有为null
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    //查看右子树是否有目标节点，没有为null
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
    if (left != null && right != null) return root;
    //如果发现了目标节点，则继续向上标记为该目标节点
    return left == null ? right : left;
  }


  static TreeNode<Integer> of(int n) {
    List<TreeNode<Integer>> list = new ArrayList<TreeNode<Integer>>();
    for (int i = 0; i < n; i++) {
      list.add(new TreeNode<Integer>(i + 1));
    }
    for (int i = 0; i < n; i++) {
      TreeNode<Integer> parent = list.get(i);
      if (i * 2 + 1 < n) {
        TreeNode<Integer> left = list.get(i * 2 + 1);
        parent.left = left;
        left.parent = parent;
      } else break;
      if (i * 2 + 2 < n) {
        TreeNode<Integer> right = list.get(i * 2 + 2);
        parent.right = right;
        right.parent = parent;
      }
    }
    return list.get(0);
  }

  private static class TreeNode<T> {
    public T val;
    public TreeNode<T> left = null;
    public TreeNode<T> right = null;
    TreeNode<T> parent;

    public TreeNode(T val) {
      this.val = val;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      TreeNode<?> treeNode = (TreeNode<?>) o;

      return val != null ? val.equals(treeNode.val) : treeNode.val == null;
    }

    @Override
    public int hashCode() {
      return val != null ? val.hashCode() : 0;
    }
  }

  @Test
  public void test() {
    _4_7LCA obj = new _4_7LCA();
    int lca = obj.getLCA(1, 3);
    Assertions.assertThat(lca).isEqualTo(1);
    lca = obj.getLCA(4, 10);
    Assertions.assertThat(lca).isEqualTo(2);
    lca = obj.getLCA(4, 5);
    Assertions.assertThat(lca).isEqualTo(2);
    lca = obj.getLCA(4, 6);
    Assertions.assertThat(lca).isEqualTo(1);
  }
}
