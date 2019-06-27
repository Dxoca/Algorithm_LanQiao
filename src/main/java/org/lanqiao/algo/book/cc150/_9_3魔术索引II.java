package org.lanqiao.algo.book.cc150;

/**
 * 允许重复......
 */
public class _9_3魔术索引II {
  private static final int[] A = {1, 1, 1, 4, 5};

  public static void main(String[] args) {
    boolean res = new _9_3魔术索引II().findMagicIndex(A, A.length);
    System.out.println(res);
  }

  public boolean findMagicIndex(int[] A, int n) {
    for (int i = 0; i < n; i++) {
      if (A[i] == i) return true;
      if (A[i] < i) i++;
      else i = A[i] - 1;
    }
    return false;
  }
}
