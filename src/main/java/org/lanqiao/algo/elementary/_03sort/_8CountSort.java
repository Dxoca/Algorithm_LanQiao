package org.lanqiao.algo.elementary._03sort;

import org.assertj.core.api.Assertions;
import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/**
 * 计数排序<br />
 * 思路：开辟新的空间，空间大小为max(source)<br />
 *      扫描source，将value作为辅助空间的下标，用辅助空间的改位置元素记录value的个数<br />
 *      如：9 7 5 3 1 ，helper=arr(10)<br />
 *      一次扫描，value为9，将helper[9]++，value为7，将helper[7]++……<br />
 *      如此这般之后，我们遍历helper，如果该位（index）的值为0，说明index不曾在source中出现<br />
 *      如果该位（index)的值为1，说明index在source中出现了1次，为2自然是出现了2次<br />
 *      遍历helper就能将source修复为升序排列<br />
 *      int[] helper = new int[maxOf(source)+1];
 *      for(int e : source)
 *        helper[e]++;
 *      k=0;
 *      for(i in 1...)
 *        while(helper[i]>0)
 *          source[k++] = i;
 *          helper[i]--;
 *
 * 时间复杂度： 扫描一次source，扫描一次helper，复杂度为N+k<br />
 * 空间复杂度：辅助空间k，k=maxOf(source)<br />
 * 非原址排序<br />
 * 稳定性：相同元素不会出现交叉，非原址都是拷来拷去<br />
 * 如果要优化一下空间，可以求minOf(source)，helper的长度位max-min+1，这样能短点<br />
 * 计数有缺陷，数据较为密集或范围较小时，适用。
 */
public class _8CountSort {
  public static void sort(int[] source) {
    int[] helper = new int[Util.maxOf(source) + 1];
    for (int e : source) {
      helper[e]++;
    }
    int current = 0;//数据回填的位置
    for (int i = 1; i < helper.length; i++) {
      while (helper[i] > 0) {
        source[current++] = i;
        helper[i]--;
      }
    }
  }

  public static void sort2(int[] source) {
    int[] helper = new int[Util.maxOf(source) + 1];
    for (int e : source) {
      helper[e]++;
    }
    for (int i = 1; i < helper.length; i++) {
      helper[i] += helper[i - 1];
    }
    int len = source.length;
    int[] target = new int[len];
    for (int i = len - 1; i >= 0; i--) {
      target[helper[source[i]] - 1] = source[i];
      helper[source[i]]--;
    }
    System.arraycopy(target, 0, source, 0, len);
  }

  public static void main(String[] args) {
    int[] arr = Util.getRandomArr(10, 1, 20);
    System.out.println("begin..." + Arrays.toString(arr));
    sort2(arr);
    System.out.println("final..." + Arrays.toString(arr));
    Assertions.assertThat(Util.checkOrdered(arr, true)).isTrue();
  }
}
