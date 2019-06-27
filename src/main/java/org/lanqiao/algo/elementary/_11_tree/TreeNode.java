package org.lanqiao.algo.elementary._11_tree;

import java.util.List;

public class TreeNode<E> {
  public E key;//data
  public TreeNode<E> parent;//parent
  public List<TreeNode<E>> children;//children

  public TreeNode(E key, TreeNode<E> parent) {
    this.key = key;
    this.parent = parent;
  }

  public TreeNode(E key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return "BSTNode [key=" + key + "]";
  }

}
