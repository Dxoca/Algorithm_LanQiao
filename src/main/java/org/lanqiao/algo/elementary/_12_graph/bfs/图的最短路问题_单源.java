package org.lanqiao.algo.elementary._12_graph.bfs;

import org.lanqiao.algo.util.Util;

/*
* bellman-ford算法
* 遍历所有的边，边有起点i和终点j，如果源点到顶点的最短距离d[i]已经算出来，就比较d[j]和d[i]+cost，如果前者比后者大，就可以更新d[j]
* 如此往复，直到没有数据可更新，这样源点到所有顶点的最短距离就算出来了
* */
public class 图的最短路问题_单源 {
  public static void main(String[] args) {
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
      //扫描所有的边
      for (int i = 0; i < n; i++) {
        //起点到i的最短距离还没算出来
        if (d[i] == Integer.MAX_VALUE)
          continue;
        for (int j = 0; j < n; j++) {
          int cost = graph[i][j]; // i,j之间的距离
          if (cost > 0) { // i,j 两点之间有边，起点是i
            if (d[j] > d[i] + cost) { // 起点先到i，i->j 两端距离加起来比起点直接到j的距离短，则更新
              update = true;
              d[j] = d[i] + cost;
            }
          }
        }
      }
      //无需任何更新，退出外循环
      if (!update) break;
    }
    return d;
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
