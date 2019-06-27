package org.lanqiao.algo.elementary._12_graph.dfs;

import java.util.Stack;

/*欧拉道路和欧拉回路*/
/*
* 从无向图中的一个结点出发走出一条道路，每条边恰好经过一次，这样的路线称为欧拉道路
*
* 如果一个无向图是连通的，且最多只有两个奇点（度数为奇数），则一定存在欧拉道路。
*
* 如果有两个奇点，它们必须是起点和，
* 如果奇点不存在，可以从任意点出发，最终一定会回到该点，称为欧拉回路
*
* */
public class 图的dfs_euler {
  static Stack<String> path = new Stack<>();
  //图的邻接矩阵
  private static int[][] graph = {
      {0, 1, 2, 1},
      {1, 0, 0, 0},
      {2, 0, 0, 1},
      {1, 0, 1, 0}
  };
  // 节点数
  private static final int n = 4;
  //标记边的访问情况，因为通路是双向的，所以用二维数组
  private static int[][] vis = new int[n][n];

  /**
   *
   * @param u 现在访问的顶点
   */
  static void euler(int u) {
    //其他顶点
    for (int v = 0; v < n; v++) {
      //有边，且访问次数少于连接数
      if (graph[u][v] > 0 && vis[u][v] < graph[u][v]) {
        //路是双向的
        vis[u][v]++;
        vis[v][u]++;
        //v作为新的起点，递归
        euler(v);
        //已走u->v，将这一步走法加入栈中
        path.push((char) ('A' + u) + "->" + (char) ('A' + v));
      }
    }
  }

  public static void main(String[] args) {
    euler(2);
    while (!path.isEmpty())
      System.out.println(path.pop());
  }

}
