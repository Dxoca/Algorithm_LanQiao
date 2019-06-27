package org.lanqiao.algo;

import java.util.Stack;
import java.util.function.Consumer;

public class TreeUtil {
  public static <T> TreeNode<T> buildTree(T rootValue, T lValue, T rValue) {
    TreeNode root = new TreeNode(rootValue);
    TreeNode left = new TreeNode(lValue);
    TreeNode right = new TreeNode(rValue);
    root.left = left;
    root.right = right;
    return root;
  }

  public static void inorderIter(TreeNode node, Consumer consumer) {
    if (null != node.left)
      inorderIter(node.left, consumer);
    consumer.accept(node.val);
    if (null != node.right)
      inorderIter(node.right, consumer);
  }

  public static void inorderIterNoRecursion(TreeNode node, Consumer consumer) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = node;
    while (curr != null) {
      // 顺着当前节点将左支路的节点从上往下加入栈中，最后：最左叶子节点在栈顶
      while (curr != null) {
        stack.add(curr);
        curr = curr.left;
      }
      //接下来开始弹弹弹，首先弹出的肯定是最左叶子
      while (!stack.isEmpty()) {
        TreeNode pop = stack.pop();
        consumer.accept(pop.val);// 弹出来的对象供消费
        //重点来了，如果弹出的节点有右孩子，就暂停弹出，应该从右孩子开始回到外层循环的起点，把右孩子作为起点重新来一轮
        if (pop.right != null) {
          curr = pop.right;
          break;
        }
      }

    }
  }

  public static void preIter(TreeNode<Integer> node) {
    System.out.print(node.val + "\t");
    if (null != node.left)
      preIter(node.left);
    if (null != node.right)
      preIter(node.right);
  }

  public static void preIterNoRecursion(TreeNode<Integer> node) {
    TreeNode curr = node;
    Stack<TreeNode> stack = new Stack<>();
    stack.add(curr);
    while (!stack.isEmpty()) {
      //弹出栈顶
      TreeNode pop = stack.pop();
      System.out.print(pop.val + "\t");
      if (pop.right != null) {
        stack.add(pop.right);
      }
      if (pop.left != null) {
        stack.add(pop.left);
      }
    }
  }
}
