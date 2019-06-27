package org.lanqiao.algo.elementary._11_tree;

import java.util.HashSet;
import java.util.Set;

public class UnionFind {

  public static UFNode find(UFNode x) {
    UFNode p = x;
    Set<UFNode> path = new HashSet<UFNode>();
    //记录向上追溯的路径上的点
    while (p.parent != null) {
      path.add(p);
      p = p.parent;
    }
    //这些点的parent全部指向这个集的代表
    for (UFNode ppp : path) {
      ppp.parent = p;
    }
    //root
    return p;

  }

  public static void union(UFNode x, UFNode y) {
    find(y).parent = find(x);
  }

  public static class UFNode {
    UFNode parent;
  }
}
