package org.lanqiao.algo.elementary._12_graph.bfs;

import java.util.HashSet;
import java.util.Set;

/*
* Dijkstra算法采用的是一种贪心的策略，声明一个数组dis来保存源点到各个顶点的最短距离和一个保存已经找到了最短路径的顶点的集合：T，
* 初始时，原点 s 的路径权重被赋为 0 （dis[s] = 0）。若对于顶点 s 存在能直接到达的边（s,m），则把dis[m]设为w（s, m）,
* 同时把所有其他（s不能直接到达的）顶点的路径长度设为无穷大。初始时，集合T只有顶点s。
* 然后，从dis数组选择最小值，则该值就是源点s到该值对应的顶点的最短路径，并且把该点加入到T中，OK，此时完成一个顶点，
* 然后，我们需要看看新加入的顶点是否可以到达其他顶点并且看看通过该顶点到达其他点的路径长度是否比源点直接到达短，
* 如果是，那么就替换这些顶点在dis中的值。
* 然后，又从dis中找出最小值，重复上述动作，直到T中包含了图的所有顶点。
* */
public class 图的最短路问题_Dijkstra2 {
  public static void main(String[] args) {
    int s = 1;
    int[] shortestPath = shortestPath(s);
    // Util.print(shortestPath);
    // Util.print(prev);

    // for (int i = 0; i < shortestPath.length; i++) {
    //   System.out.print((char) ('A' + s) + "->" + (char) ('A' + i) + ":" + shortestPath[i] + ";\t");
    // }
    // System.out.println();

    for (int i = 0; i < prev.length; i++) {
      System.out.println((char) ('A' + s) + "到" + (char) ('A' + i) + "的路径");
      System.out.print((char) ('A' + i) + "<-");
      int j = prev[i];
      while (j != s) {
        System.out.print((char) ('A' + j) + "<-");
        j = prev[j];
      }
      System.out.print((char) ('A' + j));
      System.out.println(":" + shortestPath[i]);
    }
  }

  static int[] prev;

  /**
   * 求起点到各顶点的最短距离
   * @param s 起点
   * @return
   */
  private static int[] shortestPath(int s) {
    //顶点个数
    int n = graph.length;
    //记录每个点的前驱
    prev = new int[n];
    //一定要初始化，源点的前驱是自身
    prev[s] = s;
    //记录s到各顶点的最短距离
    int[] d = new int[n];
    d[s] = 0;//自己到自己的距离为0
    //记录已经找到最短距离的顶点
    Set<Integer> T = new HashSet<>();
    T.add(s);

    /*-第一步：直接可达的顶点，用距离来初始化d,d[s]=0，可直达的把距离记录下来作为待定值-*/
    for (int i = 0; i < n; i++) {
      if (i != s && graph[s][i] == 0) d[i] = Integer.MAX_VALUE;//不可直达的顶点，先以最大整数作为待定值
      if (i != s && graph[s][i] > 0) {
        d[i] = graph[s][i]; // 可直达的顶点，以直达距离作为待定值
        prev[i] = s;  // 可直达的顶点，其前驱是源点
      }
    }
    // Util.print(d);

    while (T.size() < n) {
    /*-第二步：从待定的距离表中找到最小值，这个值可以作为确定值，为什么？-*/
      //找d中不在T中的最小的
      int min = minIndex(d, T);
      T.add(min);
      if (T.size() == n) break;
    /*-第三步，看这个新确定的顶点的出度，看看从源点出发是经过这个顶点到其邻居近还是直达更近,如果更近就要更新-*/
      //扫描index的邻居
      for (int neighbor = 0; neighbor < n; neighbor++) {
        int cost = graph[min][neighbor];
        //更新
        if (cost > 0 && d[neighbor] > d[min] + cost) {
          d[neighbor] = d[min] + cost;
          prev[neighbor] = min; // 更新最短路后，要更新i这个点的前驱
        }
      }
    }
    return d;
  }

  /**
   * 从未确定的点里面找一个最小的
   * @param d
   * @param t 已确定了最短距离的顶点集
   * @return
   */
  private static int minIndex(int[] d, Set<Integer> t) {
    int index = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < d.length; i++) {
      if (!t.contains(i) && d[i] < min) {
        min = d[i];
        index = i;
      }
    }
    return index;
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
