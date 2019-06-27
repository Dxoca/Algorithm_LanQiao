package org.lanqiao.algo;

public class TreeNode<T> {

  public T val;
  public TreeNode<T> left = null;
  public TreeNode<T> right = null;
  public TreeNode<T> parent = null;

  public TreeNode(T val) {
    this.val = val;
  }


}