package org.lanqiao.algo.elementary._12_graph.problemset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class POJ_1502 {
  /*5
  50
  30 5
  100 20 50
  10 x x 10*/
  static int[][] graph;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    graph = new int[n][n];
    graph[0][0] = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        try {
          graph[i][j] = Integer.parseInt(sc.next());
          graph[j][i] = graph[i][j];
        } catch (NumberFormatException e) {
          graph[i][j] = 0;
          graph[j][i] = graph[i][j];
        }
      }
    }
    // System.out.println(graph);
    int[] d = shortestPath(0);

    int res = 0;
    for (int i = 0; i < d.length; i++) {
      if (d[i] > res)
        res = d[i];
    }
    System.out.println(res);
  }

  private static int[] shortestPath(int s) {
    //顶点个数
    int n = graph.length;
    //记录每个点的前驱
    // prev = new int[n];
    //一定要初始化，源点的前驱是自身
    // prev[s] = s;
    //记录s到各顶点的最短距离
    int[] d = new int[n];
    d[s] = 0;//自己到自己的距离为0
    //记录已经找到最短距离的顶点
    Set<Integer> T = new HashSet<Integer>();
    T.add(s);

    /*-第一步：直接可达的顶点，用距离来初始化d,d[s]=0，可直达的把距离记录下来作为待定值-*/
    for (int i = 0; i < n; i++) {
      if (i != s && graph[s][i] == 0) d[i] = Integer.MAX_VALUE;//不可直达的顶点，先以最大整数作为待定值
      if (i != s && graph[s][i] > 0) {
        d[i] = graph[s][i]; // 可直达的顶点，以直达距离作为待定值
        // prev[i] = s;  // 可直达的顶点，其前驱是源点
      }
    }
    // Util.print(d);

    while (T.size() < n) {
    /*-第二步：从待定的距离表中找到最小值，这个值可以作为确定值，为什么？-*/
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
          // prev[neighbor] = min; // 更新最短路后，要更新i这个点的前驱
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

}
