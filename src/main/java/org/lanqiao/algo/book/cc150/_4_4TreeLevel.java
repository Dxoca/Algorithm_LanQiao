package org.lanqiao.algo.book.cc150;


import org.lanqiao.algo.TreeNode;

import java.util.*;

// class ListNode {
//     int data;
//     ListNode next = null;
//
//     ListNode(int data) {
//         this.data = data;
//     }
// }

//class TreeNode {
//  int data = 0;
//  TreeNode left = null;
//  TreeNode right = null;
//
//  public TreeNode(int data) {
//    this.data = data;
//  }
//}

/**
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，
 代表该深度上所有结点的值，请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class _4_4TreeLevel {
  public ListNode getTreeLevel(TreeNode<Integer> root, int dep) {
    if (root != null && dep == 1)
      return new ListNode(root.val);

    if (root == null)
      return null;

    ListNode head = null;
    ListNode last = null;
    Queue<NodeAndHeight> queue = new LinkedList<>();
    queue.offer(new NodeAndHeight(root, 1)); // 根节点入队
    while (!queue.isEmpty()) {
      NodeAndHeight poll = queue.poll();
      //对弹出节点，检查其层次，如果层次==指定的depth，加入到链表中
      if (poll.height == dep) {
        if (head == null) {
          head = new ListNode(poll.node.val);
          last = head;
        } else {
          last.next = new ListNode(poll.node.val);
          last = last.next;
        }
      } else if (poll.height > dep) {
        break;
      }
      //加入新节点时，维护节点的层次
      if (poll.node.left != null && poll.height < dep) {
        queue.offer(new NodeAndHeight(poll.node.left, poll.height + 1));
      }
      if (poll.node.right != null && poll.height < dep) {
        queue.offer(new NodeAndHeight(poll.node.right, poll.height + 1));
      }
    }
    return head;
  }

  class NodeAndHeight {
    TreeNode<Integer> node;
    int height;

    NodeAndHeight(TreeNode node, int height) {
      this.node = node;
      this.height = height;
    }
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    node.left = node2;
    node.right = node3;

    node2.left = node4;
    node3.right = node5;
    ListNode listNode = new _4_4TreeLevel().getTreeLevel(node, 3);
    System.out.println(listNode);

  }
}
