package org.lanqiao.algo.elementary._03sort;

import org.lanqiao.algo.util.Util;

/*有一个整数数组，存在索引a和b，只要将a和b之间的元素排好序，整个数组就是有序（升序）的。
注意：b-a应该越小越好，也就是说，找出符合条件的最短序列。

给定一个int数组A和数组的大小n，请输出a和b，若原数组有序，输出0和0。保证A中元素均为正整数。

测试样例：
6
1 4 6 5 9 10
输出：2 3
*/
public class Case08_Rearrange {
  public int[] findSegment(int[] A, int n) {
    int p1 = -1;
    int p2 = -1;
    int max = A[0];
    int min = A[n - 1];
    //拓展右端点：更新历史最高，只要右侧出现比历史最高低的，就应该将右边界扩展到此处
    for (int i = 0; i < n; i++) {
      // if (i < n - 1 && A[i] > A[i + 1] && p1 == -1) {//出现第一个折点
      //   p1 = i;
      //   // if (A[i] > max) {
      //   //   max = A[i];
      //   // }
      // }
      if (A[i] > max) {
        max = A[i];
      }
      //只要低于历史高峰，就要扩展需排序区间的右端点
      if (A[i] < max)
        p2 = i;
    }
    //找左端点：更新历史最低，只要左侧出现比历史最低高的，就应该将左边界扩展到此处
    for (int i = n - 1; i >= 0; i--) {

      if (A[i] < min) {
        min = A[i];
      }
      if (A[i] > min)
        p1 = i;
    }

    if (p1 == -1) {
      return new int[]{0, 0};
    }
    return new int[]{p1, p2};
  }

  public static void main(String[] args) {
    Case08_Rearrange obj = new Case08_Rearrange();
    int[] A = {1, 4, 6, 5, 9, 10};
    int[] res = obj.findSegment(A, 6);
    Util.print(res);

    A = new int[]{1, 2, 3, 4, 5, 6};
    res = obj.findSegment(A, A.length);
    Util.print(res);

    A = new int[]{1, 5, 3, 4, 2, 6, 7};
    res = obj.findSegment(A, A.length);
    Util.print(res);

    A = new int[]{2, 3, 7, 5, 4, 6};
    res = obj.findSegment(A, A.length);
    Util.print(res);
    A = new int[]{3, 2, 5, 6, 7, 8};
    res = obj.findSegment(A, A.length);
    Util.print(res);

    A = new int[]{2, 8, 7, 10, 9};
    res = obj.findSegment(A, A.length);
    Util.print(res);

    A = new int[]{2, 3, 7, 4, 1, 5, 6};
    res = obj.findSegment(A, A.length);
    Util.print(res);
  }
}
