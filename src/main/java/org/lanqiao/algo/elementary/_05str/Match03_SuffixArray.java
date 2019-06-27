package org.lanqiao.algo.elementary._05str;

import java.util.Arrays;

/**
 * 后缀数组实现及应用
 */
public class Match03_SuffixArray {

  public static int[] getHeight(String src, Suff[] sa) {
    // Suff[] sa =getSa2(src);
    int strLength = src.length();
    int[] rk = new int[strLength];
    //将rank表示为不重复的排名即0~n-1
    for (int i = 0; i < strLength; i++) {
      rk[sa[i].index] = i;
    }
    int[] height = new int[strLength];
    // 如果已经知道后缀数组中i与i+1的lcp为h，那么i代表的字符串与i+1代表的字符串去掉首字母后的lcp为h-1.
    // 根据这个我们可以发现，如果知道i与后缀数组中在它后一个的lcp为k，那么它去掉首字母后的字符串与其在后缀数组中的后一个的lcp大于等于k-1.
    // 例如对于字符串abcefabc，我们知道abcefabc与abc的lcp为3.
    //     那么bcefabc与bc的lcp大于等于3-1.
    // 利用这一点就可以O(n)求出高度数组。
    int k = 0;
    for (int i = 0; i < strLength; i++) {
      int rk_i = rk[i];//i后缀的排名
      if (rk_i == 0) {
        height[0] = 0;
        continue;
      }
      int rk_i_1 = rk_i - 1;
      int j = sa[rk_i_1].index;//j是i串字典序靠前的串的下标
      if (k > 0) k--;

      for (; j + k < strLength && i + k < strLength; k++) {
        if (src.charAt(j + k) != src.charAt(i + k))
          break;
      }
      height[rk_i] = k;
    }
    return height;
  }


  /**
   * nlg²n  构建后缀数组
   * @param src
   * @return
   */
  public static Suff[] getSa2(String src) {
    int n = src.length();
    Suff[] sa = new Suff[n];
    for (int i = 0; i < n; i++) {
      sa[i] = new Suff(src.charAt(i), i, src);//存单个字符,接下来排序
    }
    Arrays.sort(sa);

    /**rk是下标到排名的映射*/
    int[] rk = new int[n];//suffix array
    rk[sa[0].index] = 1;
    for (int i = 1; i < n; i++) {
      rk[sa[i].index] = rk[sa[i - 1].index];
      if (sa[i].c != sa[i - 1].c) rk[sa[i].index]++;
    }
    //倍增法
    for (int k = 2; rk[sa[n - 1].index] < n; k *= 2) {

      final int kk = k;
      Arrays.sort(sa, (o1, o2) -> {
        //不是基于字符串比较,而是利用之前的rank
        int i = o1.index;
        int j = o2.index;
        if (rk[i] == rk[j]) {//如果第一关键字相同
          if (i + kk / 2 >= n || j + kk / 2 >= n)
            return -(i - j);//如果某个后缀不具有第二关键字,那肯定较小,索引靠后的更小
          return rk[i + kk / 2] - rk[j + kk / 2];

        } else {
          return rk[i] - rk[j];
        }
      });
      /*---排序 end---*/
      // 更新rank
      rk[sa[0].index] = 1;
      for (int i = 1; i < n; i++) {
        int i1 = sa[i].index;
        int i2 = sa[i - 1].index;
        rk[i1] = rk[i2];
        try {
          if (!src.substring(i1, i1 + kk).equals(src.substring(i2, i2 + kk)))
            rk[i1]++;
        } catch (Exception e) {
          rk[i1]++;
        }
      }
    }

    return sa;
  }


/**
 * 直接对所有后缀排序,因为字符串的比较消耗O(n)
 * 所以整体为n²log(n)
 */
  /*public static Suff[] getSa(String src) {
    int strLength = src.length();
    */

  /**sa是排名到下标的映射,即sa[i]=k说明排名为i的后缀是从k开始的*//*
    Suff[] suffixArray = new Suff[strLength];
    for (int i = 0; i < strLength; i++) {
      String suffI = src.substring(i);//截取后缀
      suffixArray[i] = new Suff(suffI, i);
    }
    Arrays.sort(suffixArray);//依据Suff的比较规则进行排序
    return suffixArray;
  }*/

  public static class Suff implements Comparable<Suff> {
    public char c;//后缀内容
    private String src;
    public int index;//后缀的起始下标

    public Suff(char c, int index, String src) {
      this.c = c;
      this.index = index;
      this.src = src;
    }

    @Override
    public int compareTo(Suff o2) {
      return this.c - o2.c;
    }

    @Override
    public String toString() {
      return "Suff{" +
          "char='" + src.substring(index) + '\'' +
          ", index=" + index +
          '}';
    }
  }
}
