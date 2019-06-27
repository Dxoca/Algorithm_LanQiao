package org.lanqiao.algo.elementary._11_tree;

import java.util.List;

public interface ITree<E> {
  /**
   * 节点数
   * @return
   */
  int getSize();

  /**
   * 获取根节点
   * @return
   */
  TreeNode<E> getRoot();

  /**
   * 获取x的父节点
   * @param x
   * @return
   */
  TreeNode<E> getParent(TreeNode<E> x);

  /**
   * 获取第一个儿子
   * @param x
   * @return
   */
  TreeNode<E> getFirstChild(TreeNode<E> x);

  /**
   * 获取x的下一个兄弟
   * @param x
   * @return
   */
  TreeNode<E> getNextSibling(TreeNode<E> x);

  /**
   * 子树高度
   * @param x
   * @return
   */
  int getHeight(TreeNode<E> x);

  /**
   * 插入子节点
   * @param x
   * @param child
   */
  void insertChild(TreeNode<E> x, TreeNode<E> child);

  /**
   * 删除第i个子节点
   * @param x
   * @param i
   */
  void deleteChild(TreeNode<E> x, int i);

  /**
   * 先序遍历
   * @param x
   * @return
   */
  List<TreeNode<E>> preOrder(TreeNode<E> x);

  /**
   * 后续遍历
   * @param x
   * @return
   */
  List<TreeNode<E>> postOrder(TreeNode<E> x);

  /**
   * 层次遍历
   * @param x
   * @return
   */
  List<List<TreeNode<E>>> levelOrder(TreeNode<E> x);

  List<List<TreeNode<E>>> levelOrder();
}
