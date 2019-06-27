package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.TreeNode;

import java.util.ArrayList;

/**
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。

 <方法1>
       首先我们想到的是二叉树中序遍历后的结果是有序的，根据这个结果，我们可以中序遍历二叉树，
 并把遍历结果存放在一个数组里面，然后判断这个数组大小是否是有序数组，如果是有序数组，则是二叉查找树，否则就不是。
     这个方法的时间复杂度是O(N)，但是空间复杂度比较高，需要浪费O（N）的存储空间。
 @author zhengwei
 */
public class _4_5CheckBST1 {
  // 中序遍历是否有序
  public boolean checkBST(TreeNode root) {
    if (root == null)
      return false;
    ArrayList<Integer> list = new ArrayList<>();
    inorder(root, list);
    return checkOrdered(list);
  }

  // 递归方式把节点按中序遍历顺序加入到列表中
  private void inorder(TreeNode<Integer> node, ArrayList<Integer> list) {
    if (node == null)
      return;
    if (node.left != null) {
      inorder(node.left, list);
    }
    list.add(node.val);
    if (node.right != null) {
      inorder(node.right, list);
    }
  }

  //遍历列表，前后两两比较，如果逆序，返回false
  private boolean checkOrdered(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 2; i++) {
      if (list.get(i) > list.get(i + 1))
        return false;
    }
    return true;
  }
}
