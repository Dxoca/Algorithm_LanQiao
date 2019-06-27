package org.lanqiao.algo.elementary._12_graph.dfs;

import org.lanqiao.algo.elementary._11_tree.UnionFind;
import org.lanqiao.algo.elementary._12_graph.Edge;

import java.util.*;

public class Kruskal {
  private final List<Edge> edgeList;
  private final int n;//总顶点数

  private Set<Edge> T = new HashSet<>();//生成树的边集
  private Map pntAndNode = new HashMap();

  public Set<Edge> getT() {
    buildMST();
    return T;
  }

  public Kruskal(List<Edge> edgeList, int n) {
    this.edgeList = edgeList;
    //为每个顶点建立一个并查集的点
    for (Edge edge : edgeList) {
      pntAndNode.put(edge.getStart(), new UnionFind.UFNode());
      pntAndNode.put(edge.getEnd(), new UnionFind.UFNode());
    }
    this.n = n;
  }

  public static void main(String[] args) {
    List<Edge> edgeList = build();
    Kruskal obj = new Kruskal(edgeList, 5);
    // obj.buildMST();
    for (Edge e : obj.getT()) {
      System.out.println(e);
    }
  }

  private static List<Edge> build() {
    List<Edge> l = new ArrayList<>();
    l.add(new Edge("C", "D", 1));
    l.add(new Edge("C", "A", 1));
    l.add(new Edge("C", "E", 8));
    l.add(new Edge("A", "B", 3));
    l.add(new Edge("D", "E", 3));
    l.add(new Edge("B", "C", 5));
    l.add(new Edge("B", "E", 6));
    l.add(new Edge("B", "D", 7));
    l.add(new Edge("A", "D", 2));
    l.add(new Edge("A", "E", 9));

    return l;
  }

  /*构建MST的核心方法*/
  private void buildMST() {
    Collections.sort(edgeList);//排序
    //迭代
    for (Edge e : edgeList) {
      if (!ok(e))
        continue;
      //确认过了，就把边都加入
      T.add(e);

      if (T.size() == n - 1)
        return;//生成树的边数==总顶点数-1 =》 所有点都已经连接
    }
  }

  //并查集中查询e的起点和终点是否在一个集中
  private boolean ok(Edge e) {
    UnionFind.UFNode x = (UnionFind.UFNode) pntAndNode.get(e.getStart());
    UnionFind.UFNode y = (UnionFind.UFNode) pntAndNode.get(e.getEnd());
    if (UnionFind.find(x) != UnionFind.find(y)) {//在不同的集中
      UnionFind.union(x, y);//合并并返回true
      return true;
    }
    return false;
  }

}