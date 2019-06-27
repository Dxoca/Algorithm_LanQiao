package org.lanqiao.algo.elementary._11_tree;

import java.util.ArrayList;
import java.util.List;

public class BSTPlus extends BinarySearchTree<Integer, Object> {
  public int numOfLeaf() {
    return numOfLeaf(root);
  }

  private int numOfLeaf(BSTNode node) {
    if (node == null) return 0;
    if (node.left == null && node.right == null) return 1;
    return numOfLeaf(node.left) + numOfLeaf(node.right);
  }

  //宽搜
  public int numOfLevel(int k) {
    return ((List) (levelOrder().get(k - 1))).size();
  }

  public boolean isComplete() {
    List<List<BSTNode<Integer, Object>>> list = levelOrder();
    for (int i = 0; i < list.size(); i++) {
      List<BSTNode<Integer, Object>> l = list.get(i);
      if (l.size() != (int) Math.pow(2, i) && i != list.size() - 1) {
        return false;
      } else if (i == list.size() - 1) {
        for (int j = 0; j < l.size(); j++) {
          BSTNode<Integer, Object> node = l.get(j);
          if (node.num != (int) Math.pow(2, i) + j)
            return false;
        }
      }
    }
    return true;
  }

  List l = new ArrayList();

  public void search(int k1, int k2) {
    search(root, k1, k2);
  }

  private void search(BSTNode<Integer, Object> node, int k1, int k2) {
    if (node == null) return;
    int k = node.key;
    if (k > k1) search(node.left, k1, k2);
    if (k >= k1 && k <= k2) l.add(k);
    if (k < k2) search(node.right, k1, k2);
  }
}
