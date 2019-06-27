package org.lanqiao.algo.book.cc150;

import org.lanqiao.algo.TreeNode;

/**
 * Given a sorted (increasing order) array,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class _4_3BSTWithMinHeight {
  TreeNode createMinBst(int[] arr) {
    return createMinBst(arr, 0, arr.length - 1);
  }

  private TreeNode createMinBst(int[] arr, int start, int end) {
    if (start > end) return null;

    int mid = start + ((end - start) >> 1);
    TreeNode left = createMinBst(arr, start, mid - 1);
    TreeNode right = createMinBst(arr, mid + 1, end);
    TreeNode res = new TreeNode(arr[mid]);
    res.left = left;
    res.right = right;
    return res;
  }

  public static void main(String[] args) {
    _4_3BSTWithMinHeight obj = new _4_3BSTWithMinHeight();
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    TreeNode minBst = obj.createMinBst(arr);
    System.out.println(minBst);
  }
}
