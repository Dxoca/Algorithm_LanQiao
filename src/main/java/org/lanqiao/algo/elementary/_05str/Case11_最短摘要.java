package org.lanqiao.algo.elementary._05str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Alibaba笔试题：给定一段产品的英文描述，包含M个英文字母，每个英文单词以空格分隔，无其他标点符号；再给定N个英文单词关键字，请说明思路并编程实现方法

String extractSummary(String description,String[] key words)

目标是找出此产品描述中包含N个关键字（每个关键词至少出现一次）的长度最短的子串，作为产品简介输出。（不限编程语言）20分。

*/
public class Case11_最短摘要 {
  public static void main(String[] args) {
    solve1(new String[]{"a", "b", "c", "seed", "h", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"c", "e"});
    solve2(new String[]{"a", "b", "c", "seed", "c", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"c", "c", "e", "f"});
    solve2(new String[]{"a", "b", "a", "a", "b", "c", "d", "h", "e", "f", "f"}, new String[]{"b", "c", "d"});
  }

  //原始暴力法
  public static void solve1(String[] w, String[] q) {
    int length = Integer.MAX_VALUE;
    int begin = -1;
    int end = -1;
    for (int i = 0; i < w.length; i++) {
      //求以i开头包含所有关键字的序列
      for (int j = i + 1; j < w.length; j++) {
        //如果全部关键词已经在seq中
        if (containsAll(q, w, i, j)) {
          //  判断当前这个序列是不是较短的序列
          // System.out.println(seq);
          if (j - i + 1 < length) {
            length = j - i + 1;
            begin = i;
            end = j;
          }
          break;
        }
      }
    }
    print(w, begin, end);
  }

  public static void solve2(String[] w, String[] keys) {
    Arrays.sort(keys);
    //begin和end用于在找到更短的包含全部关键字的子数组时更新
    int begin = -1;
    int end = -1;

    int j = -1;//上一次囊括了所有关键字的右边界

    int minLen = Integer.MAX_VALUE;
    for (int i = 0; i < w.length; i++) {
      //如果i位置是关键字，求以i开头包含所有关键字的序列
      String word1 = w[i];
      int index = Arrays.binarySearch(keys, word1);
      if (-1 == index) {
        continue;
      } else {//i是一个关键字
        if (j < w.length && j >= i && containsAll(keys, w, i, j)) {//如果已经全部找到
          if (j - i + 1 < minLen) {//更新
            minLen = j - i + 1;
            begin = i;
            end = j;
          }
          continue;
        }
      }

      if (j == -1)
        j = i + 1;
      while (j < w.length) {
        String word2 = w[j];//文章单词
        int index1 = Arrays.binarySearch(keys, word2);
        if (index1 == -1) {
          j++;
          continue;
        } else {//找到关键字
          if (containsAll(keys, w, i, j)) {//全部到齐
            if (j - i + 1 < minLen) {//更新
              minLen = j - i + 1;
              begin = i;
              end = j;
            }
            break;
          } else {
            j++;
          }
        }
      }
    }
    print(w, begin, end);
  }

  private static void print(String[] w, int begin, int end) {
    System.out.println(begin + " " + end);
    for (int i = begin; i <= end; i++) {
      System.out.print(w[i] + " ");
    }
    System.out.println();
  }

  private static boolean containsAll(String[] keyWords, String[] w, int i, int j) {
    Map<String, Integer> map = new HashMap<>();
    for (int k = 0; k < keyWords.length; k++) {
      String key = keyWords[k];
      if (map.get(key) == null) {
        map.put(key, 1);
      } else {
        map.put(key, map.get(key) + 1);
      }
    }
    Map<String, Integer> map2 = new HashMap<>();

    for (int k = i; k <= j; k++) {
      String key = w[k];
      if (map2.get(key) == null) {
        map2.put(key, 1);
      } else {
        map2.put(key, map2.get(key) + 1);
      }
    }
    for (Map.Entry<String, Integer> e :
        map.entrySet()) {
      if (map2.get(e.getKey()) == null || map2.get(e.getKey()) < e.getValue()) {
        return false;
      }
    }
    return true;
  }
}
