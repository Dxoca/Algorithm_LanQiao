package org.lanqiao.algo.elementary._11_tree;

import org.junit.Before;
import org.junit.Test;
import org.lanqiao.algo.elementary._11_tree.Trie;

public class TrieTest {
  @Test
  public void search() throws Exception {
    trie.search("hat");
  }

  Trie trie = new Trie();

  @Before
  public void insert() throws Exception {
    trie.insert("def");
    trie.insert("a");
    trie.insert("abcd");
    trie.insert("ab");
    trie.insert("c");
    trie.insert("hit");
    trie.insert("hat");
    trie.insert("had");
    trie.insert("have");
    trie.insert("hate");
  }

  @Test
  public void dfs() throws Exception {
    trie.printAll();
  }


}