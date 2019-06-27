package org.lanqiao.algo.elementary._03sort;

import org.lanqiao.algo.util.Util;

import java.util.Scanner;

/**
 * 求海量数据（正整数）按逆序排列的前k个数（topK），因为数据量太大，不能全部存储在内存中，只能一个一个地从磁盘或者网络上读取数据，
 * 请设计一个高效的算法来解决这个问题
 第一行：用户输入K，代表要求得topK
 随后的N（不限制）行，每一行是一个整数代表用户输入的数据
 用户输入-1代表输入终止
 请输出topK，从小到大，空格分割

 */
public class Case09_TopK {

  static int[] heap;
  static int index = 0;
  static int k;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    k = sc.nextInt();
    heap = new int[k];
    int x = sc.nextInt();
    while (x != -1) {
      deal(x);//处理x
      x = sc.nextInt();
    }
    printRs();
  }

  private static void printRs() {
    Util.print(heap);
  }

  /**
   * 如果数据数量小于等于k，直接加入堆中
   * 等于k的时候，进行堆化
   * @param x
   */
  private static void deal(int x) {
    if (index < k) {
      heap[index++] = x;
      if (index == k) {
        //堆化
        makeMinHeap(heap);
      }
    } else
      //x和堆顶进行比较,如果x大于堆顶，x将堆顶挤掉并向下调整
      if (heap[0] < x) {
        heap[0] = x;
        MinHeapFixDown(heap, 0, k);
        printRs();
      }
  }

  static void makeMinHeap(int[] A) {
    int n = A.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      MinHeapFixDown(A, i, n);
    }
  }

  static void MinHeapFixDown(int[] A, int i, int n) {
    // 找到左右孩子
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    //左孩子已经越界，i就是叶子节点
    if (left >= n) {
      return;
    }
    int min = left;
    if (right >= n) {
      min = left;
    } else {
      if (A[right] < A[left]) {
        min = right;
      }
    }
    //min指向了左右孩子中较小的那个

    // 如果A[i]比两个孩子都要小，不用调整
    if (A[i] <= A[min]) {
      return;
    }
    //否则，找到两个孩子中较小的，和i交换
    int temp = A[i];
    A[i] = A[min];
    A[min] = temp;
    //小孩子那个位置的值发生了变化，i变更为小孩子那个位置，递归调整
    MinHeapFixDown(A, min, n);
  }
}
