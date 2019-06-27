package org.lanqiao.algo.elementary._11_tree;

public class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String str) {
    char[] chars = str.toCharArray();
    TrieNode p = root;
    //遍历单词的每个字符
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      TrieNode child = p.children[c - 'a'];
      if (child == null) {
        TrieNode nnode = new TrieNode();
        nnode.level = i;
        p.children[c - 'a'] = nnode;
        p = nnode;
      } else {
        p = child;
        child.fre++;
      }
    }
    p.isLast = true;
  }

  /**
   * 深度遍历
   */
  public void printAll() {
    print("", root);
  }

  private void print(String prefix, TrieNode p) {
    if (p.isLast && prefix.length() > 0) {
      System.out.println(prefix + " " + p.fre);
    }
    for (int i = 0; i < 26; i++) {
      if (p.children[i] != null) {
        print(prefix + (char) ('a' + i), p.children[i]);
      }
    }
  }

  public void search(String prefix) {
    char[] chars = prefix.toCharArray();
    TrieNode p = root;
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      TrieNode child = p.children[c - 'a'];
      if (child == null) {//结算
        return;
      } else {
        p = child;
      }
    }
    print("", p);
  }

}
