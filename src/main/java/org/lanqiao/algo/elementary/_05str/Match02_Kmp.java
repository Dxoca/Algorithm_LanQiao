package org.lanqiao.algo.elementary._05str;

public class Match02_Kmp {
  public static void main(String[] args) {
    String src = "babababcbabababb";
    int index = indexOf(src, "bababb");
    index = indexOf1(src, "bab");
    System.out.println(index);
  }

  //O(m+n),求count
  private static int indexOf1(String s, String p) {
    if (s.length() == 0 || p.length() == 0) return -1;
    if (p.length() > s.length()) return -1;

    int count = 0;
    int[] next = next(p);
    int i = 0;//s位置
    int j = 0;//p位置
    int sLen = s.length();
    int pLen = p.length();

    while (i < sLen) {
      //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
      //j=-1，因为next[0]=-1,说明p的第一位和i这个位置无法匹配，这时i，j都增加1，i移位，j从0开始
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        i++;
        j++;
      } else {
        //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
        //next[j]即为j所对应的next值
        j = next[j];
      }
      if (j == pLen) {//匹配成功了
        count++;
        i--;
        j = next[j - 1];
        // return (i - j);
      }
    }
    return count;
  }

  public static int[] next(String ps) {
    int pLength = ps.length();
    int[] next = new int[pLength + 1];
    char[] p = ps.toCharArray();
    next[0] = -1;
    if (ps.length() == 1)
      return next;
    next[1] = 0;

    int j = 1;
    int k = next[j];//看看位置j的最长匹配前缀在哪里

    while (j < pLength) {
      //现在要推出next[j+1],检查j和k位置上的关系即可
      if (k < 0 || p[j] == p[k]) {
        next[++j] = ++k;
      } else {
        k = next[k];
      }
    }
    return next;
  }

  /**
   * 暴力解法
   * @param s
   * @param p
   * @return
   */
  private static int indexOf(String s, String p) {
    int i = 0;
    int sc = i;
    int j = 0;
    while (sc < s.length()) {
      if (s.charAt(sc) == p.charAt(j)) {
        sc++;
        j++;
        if (j == p.length())
          return i;
      } else {
        i++;
        sc = i;//扫描指针以i为起点
        j = 0;//j恢复为0
      }
    }
    return -1;
  }
}
