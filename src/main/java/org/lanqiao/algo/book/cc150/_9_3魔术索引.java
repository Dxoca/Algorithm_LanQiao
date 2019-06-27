package org.lanqiao.algo.book.cc150;

/**
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，
 * 元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。

 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 */
public class _9_3魔术索引 {
  private static final int[] A = {-1, -2, 2, 4, 5};

  public static void main(String[] args) {
    boolean res = new _9_3魔术索引().findMagicIndex(A, A.length);
    System.out.println(res);
  }

  public boolean findMagicIndex(int[] A, int n) {
    int l = 0;
    int r = n - 1;
    while (l <= r) {
      int mid = l + ((r - l) >> 1);
      if (A[mid] == mid) return true;
      else if (A[mid] > mid) r = mid - 1;
      else l = mid + 1;
    }
    return false;
  }
}
