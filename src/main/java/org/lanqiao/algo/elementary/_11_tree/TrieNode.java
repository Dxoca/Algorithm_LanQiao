package org.lanqiao.algo.elementary._11_tree;

public class TrieNode {
  int level;
  TrieNode[] children = new TrieNode[26]; // 子节点信息
  TrieNode parent; // 当前节点的父节点

  public boolean isLast;

  public int fre = 1;//出现频率
}
