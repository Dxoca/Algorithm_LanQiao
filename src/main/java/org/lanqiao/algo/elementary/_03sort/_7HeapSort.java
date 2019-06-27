package org.lanqiao.algo.elementary._03sort;

import org.assertj.core.api.Assertions;
import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/**
 * 思路：首先要知道大顶堆和小顶堆，数组就是一个堆，每个i节点的左右孩子是2i+1和2i+2<br />
 *      有了堆，将其堆化：从n/2-1个元素开始向下修复，将每个节点修复为小（大）顶堆<br />
 *      修复完成后，数组具有小（大）顶堆的性质<br />
 *      按序输出：小顶堆可以对数组逆序排序，每次交换栈顶和末尾元素，对栈顶进行向下修复，这样次小元素又到堆顶了<br />
 *
 * 时间复杂度： 堆化：一半的元素修复，修复是单分支的，所以整体堆化为nlgn/2<br />
 * 排序：n个元素都要取出，因此调整n次，每次调整修复同上是lgn的，整体为nlgn
 * 空间复杂度：不需要开辟辅助空间<br />
 * 原址排序<br />
 * 稳定性：<br />
 */
public class _7HeapSort {
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

  //
  // public static void sortDesc(int[] arr) {
  //   makeMinHeap( arr );  // 1.建立小顶堆
  //   int length = arr.length;
  //   for (int i = length - 1; i >= 1; i--) {
  //     Util.swap( arr, i, 0 ); // 堆顶（最小）元素换到元素末尾，末尾元素到了堆顶
  //     MinHeapFixDown( arr, 0, i );// 调整堆顶，边界递减
  //   }
  // }
  static void sort(int[] A) {
    //先对A进行堆化
    makeMinHeap(A);
    for (int x = A.length - 1; x >= 0; x--) {
      //把堆顶，0号元素和最后一个元素对调
      Util.swap(A, 0, x);
      //缩小堆的范围，对堆顶元素进行向下调整
      MinHeapFixDown(A, 0, x);
    }
  }
  public static void main(String[] args) {
    int[] arr = Util.getRandomArr(10, 1, 100);
    System.out.println( "begin..." + Arrays.toString( arr ) );
    sort(arr);
    System.out.println( "final..." + Arrays.toString( arr ) );
    Assertions.assertThat( Util.checkOrdered( arr, false ) ).isTrue();
  }
}
