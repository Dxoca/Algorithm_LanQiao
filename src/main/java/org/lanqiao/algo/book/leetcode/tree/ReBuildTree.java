package org.lanqiao.algo.book.leetcode.tree;

import org.lanqiao.algo.TreeNode;
import org.lanqiao.algo.TreeUtil;

/**
 * 重构二叉树
 * 通过前序迭代顺序和中序迭代顺序恢复二叉树
 * @author zhengwei 2017-08-03
 */
public class ReBuildTree {
    public static void main(String[] args) {
        TreeNode<Integer> node = new ReBuildTree().construct(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        TreeUtil.preIter(node);
        System.out.println();
        TreeUtil.inorderIter(node, System.out::print);
    }


    private TreeNode<Integer> construct(int[] preOrder, int[] inorder) {
        return construct(preOrder, 0, 7, inorder, 0, 7);
    }

    /**
     * 务必搞定对应区间
     * @param preOrder 前序遍历数组
     * @param scan
     * @param e1
     * @param inOrder 中序遍历数组
     * @param b2
     * @param e2
     * @return
     */
    TreeNode<Integer> construct(int[] preOrder, int scan, int e1, int[] inOrder, int b2, int e2) {
        //凡是交叉或越界，返回null
        if (scan > e1 || b2 > e2 || e1 < 0 || e2 < 0)
            return null;
        int rootValue = preOrder[scan];// 前序遍历的第一个是根节点
        int index = indexOf(inOrder, rootValue, b2, e2); // 根节点在中序遍历数组中的索引
        if (index == -1)
            return null;
        TreeNode<Integer> rootNode = new TreeNode<Integer>(rootValue); // 构建根节点
        // pre 从scan+1 取index-1-b2个元素  in 从b2 取index-1-b2个
        rootNode.left = construct(preOrder, scan + 1, scan + index - b2, inOrder, b2, index - 1);
        // pre从跳过左子树的第一个元素开始取，个数为e2-index-1  in从index+1开始，取e2-index-1个元素
        rootNode.right = construct(preOrder, scan + 1 + index - b2, scan + e2 - b2, inOrder, index + 1, e2);
        return rootNode;
    }

    private int indexOf(int[] arr, int key, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }


}
