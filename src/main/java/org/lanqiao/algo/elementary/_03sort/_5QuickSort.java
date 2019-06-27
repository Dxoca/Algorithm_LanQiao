package org.lanqiao.algo.elementary._03sort;

import org.lanqiao.algo.elementary._02searchAndSort._3InsertionSort;
import org.lanqiao.algo.util.Util;

public class _5QuickSort {
  /*QuickSort
  quickSort(A,p,r)
    if(p<r)
      q = partition(A,p,r)
      quickSort(A,p,q-1)
      quickSort(A,q+1,r)

  partition(A,p,r)：
    pivot = A[p]
    sp = p+1  //扫描指针
    bigger = r //右侧指针
    while(sp<=bigger):
      if(A[sp]<=pivot)//扫描元素小于主元，左指针向右移
        sp++
      else
        swap(A,sp,bigger)//扫描元素大于主元，二指针的元素交换，右指针左移
        bigger--

    swap(A,p,bigger)
    return bigger
*/
  public static void main(String[] args) {
    int[] arr = Util.getRandomArr(10, 1, 20);
    // arr=new int[]{2,1,3};
    Util.print(arr);
    quickSort(arr, 0, arr.length - 1);
    // int i = partition2(arr, 0, 2);
    // System.out.println(i);

    Util.print(arr);

  }

  public static void quickSort(int[] A, int p, int r) {
    if (p < r) {
      //待排序个数小于等于8的时候，插入排序
      if (p - r + 1 <= 8) {
        _3InsertionSort.sort(A, p, r);
      } else {
        int q = partition2(A, p, r);
        quickSort(A, p, q - 1);
        quickSort(A, q + 1, r);
      }
    }
  }

  public static int partition(int[] A, int p, int r) {
    int pivot = A[p];
    int sp = p + 1; //扫描指针
    int bigger = r; //右侧指针
    while (sp <= bigger) {
      if (A[sp] <= pivot)//扫描元素小于主元，左指针向右移
        sp++;
      else {
        Util.swap(A, sp, bigger);//扫描元素大于主元，二指针的元素交换，右指针左移
        bigger--;
      }
    }
    Util.swap(A, p, bigger);
    return bigger;
  }

  public static int partition2(int[] A, int p, int r) {
    //优化，在p,r,mid之间，选一个中间值作为主元
    int midIndex = p + ((r - p) >> 1);//中间下标
    int midValueIndex = -1;//中值的下标
    if ((A[p] <= A[midIndex] && A[p] >= A[r]) || (A[p] >= A[midIndex] && A[p] <= A[r])) {
      midValueIndex = p;
    } else if ((A[r] <= A[midIndex] && A[r] >= A[p]) || A[r] >= A[midIndex] && A[r] <= A[p]) {
      midValueIndex = r;
    } else {
      midValueIndex = midIndex;
    }
    Util.swap(A, p, midValueIndex);
    int pivot = A[p];

    int left = p + 1;//扫描指针
    int right = r;//右侧指针
    while (left <= right) {
      while (left <= right && A[left] <= pivot) left++;
      while (left <= right && A[right] > pivot) right--;
      if (left < right) {
        Util.swap(A, left, right);
      }
    }

    Util.swap(A, p, right);
    return right;
  }
}
