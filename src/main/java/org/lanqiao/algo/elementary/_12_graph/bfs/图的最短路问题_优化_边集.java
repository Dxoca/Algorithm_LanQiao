package org.lanqiao.algo.elementary._12_graph.bfs;

import org.lanqiao.algo.elementary._12_graph.Edge;
import org.lanqiao.algo.util.Util;

import java.util.ArrayList;
import java.util.List;

/*
* bellman-ford算法
* 遍历所有的边，边有起点i和终点j，如果源点到起点的最短距离d[i]已经算出来，就比较d[j]和d[i]+cost，如果前者比后者大，就可以更新d[j]
* 如此往复，直到没有数据可更新，这样源点到所有顶点的最短距离就算出来了
*
* 对于上一个代码，可以先把边集提取出来，这样不用每次都扫描二维数组
* */
public class 图的最短路问题_优化_边集 {
  public static void main(String[] args) {
    edges = buildEdges(graph);
    int[] shortestPath = shortestPath(0);
    Util.print(shortestPath);
  }

  /**
   * 求起点到各顶点的最短距离
   * @param s 起点
   * @return
   */
  private static int[] shortestPath(int s) {
    int n = graph.length;
    //记录s到各顶点的最短距离
    int[] d = new int[n];
    for (int i = 0; i < n; i++) {
      d[i] = Integer.MAX_VALUE;
    }
    d[s] = 0;//到自己的距离为0
    while (true) {
      boolean update = false;

      for (Edge<Integer> e : edges) {
        if (d[e.getStart()] != Integer.MAX_VALUE && d[e.getEnd()] > d[e.getStart()] + e.getDistance()) {
          update = true;
          d[e.getEnd()] = d[e.getStart()] + e.getDistance();
        }
      }

      if (!update) break;
    }
    return d;
  }

  static List<Edge<Integer>> edges;

  static List<Edge<Integer>> buildEdges(int[][] graph) {
    int n = graph.length;
    List<Edge<Integer>> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cost = graph[i][j]; // i,j之间的距离
        if (cost > 0) { // i,j 两点之间有边，起点是i
          edges.add(new Edge<>(i, j, cost));
        }
      }
    }
    return edges;
  }

  static int[][] graph = {
      {0, 2, 5, 0, 0, 0, 0},
      {2, 0, 4, 6, 10, 0, 0},
      {5, 4, 0, 2, 0, 0, 0},
      {0, 6, 2, 0, 0, 1, 0},
      {0, 10, 0, 0, 0, 3, 5},
      {0, 0, 0, 1, 3, 0, 9},
      {0, 0, 0, 0, 5, 9, 0}
  };
}
