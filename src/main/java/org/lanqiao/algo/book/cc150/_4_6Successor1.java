package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.TreeNode;
import org.lanqiao.algo.TreeUtil;

import java.util.Stack;

/**
 * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
 */
/*没有parent指针，又该怎么办呢？*/
public class _4_6Successor1 {
  public int findSucc(TreeNode<Integer> root, int p) {
    if (root == null)
      return -1;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curr = root;
    boolean isFound = false;
    //curr不为空或者栈不为空，都可以继续处理
    while (curr != null || !stack.isEmpty()) {//没有生产也没有消费，就退出循环了
      // 左支路依次入栈
      while (curr != null) {
        stack.add(curr);
        curr = curr.left;
      }
      if (!stack.isEmpty()) {
        TreeNode<Integer> pop = stack.pop();//栈的弹出顺序就是中序遍历的顺序
        //上一轮修改了标志位，当前出栈的值就是我们需要的值
        if (isFound) {
          return pop.val;
        }
        // 如果弹出值和p相同，那么下次弹出的值就是我们需要的值，修改标志位
        else if (pop.val == p) {
          isFound = true;
        }
        //  curr指向pop的右子树，继续外层循环
        curr = pop.right;//有可能为空，为空，只消费栈中内容，不为空，就要向栈中生产若干内容
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = TreeUtil.buildTree(1, 2, 3);
    root.left.left = TreeUtil.buildTree(4, 5, 6);
    root.right.right = TreeUtil.buildTree(7, 8, 9);

    System.out.println(new _4_6Successor1().findSucc(root, 3));
  }
}
