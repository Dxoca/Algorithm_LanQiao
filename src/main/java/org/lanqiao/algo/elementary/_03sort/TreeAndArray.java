package org.lanqiao.algo.elementary._03sort;

public class TreeAndArray {
  /**
   * 树的先序遍历
   * @param arr
   * @param i
   */
  static void preOrder(int[] arr, int i) {
    if (i >= arr.length)
      return;
    System.out.println(arr[i]);//先输出根节点
    preOrder(arr, i * 2 + 1);//输出左子树
    preOrder(arr, i * 2 + 2);//输出右子树
  }

  /**
   * 树的中序遍历
   * @param arr
   * @param i
   */
  static void inOrder(int[] arr, int i) {
    if (i >= arr.length)
      return;
    inOrder(arr, i * 2 + 1);//递归输出左子树
    System.out.println(arr[i]);//输出根节点
    inOrder(arr, i * 2 + 2);//递归输出右子树
  }

  public static void main(String[] args) {
    int[] arr = {78, 56, 34, 43, 4, 1, 15, 2, 23};
    preOrder(arr, 0);
    System.out.println("==============");
    inOrder(arr, 0);
  }
}
