package org.lanqiao.algo.elementary._12_graph.problemset;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
...11111111111111111111111111111
11.111111........1111111111.1111
11.111111..111.11111111.....1111
11.11111111111.1111111111.111111
11.111111.................111111
11.111111.11111111111.11111.1111
11.111111.11111111111.11111..111
11..........111111111.11111.1111
11111.111111111111111.11....1111
11111.111111111111111.11.11.1111
11111.111111111111111.11.11.1111
111...111111111111111.11.11.1111
111.11111111111111111....11.1111
111.11111111111111111111111.1111
111.1111.111111111111111......11
111.1111.......111111111.1111.11
111.1111.11111.111111111.1111.11
111......11111.111111111.1111111
11111111111111.111111111.111...1
11111111111111...............1.1
111111111111111111111111111111..

如上图的迷宫，入口，出口分别：左上角，右下角
"1"是墙壁，"."是通路
求最短需要走多少步？
* */
public class 图的bfs_迷宫 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = 21;
    int n = 32;
    char[][] graph = new char[m][n];
    int[][] vis = new int[m][n];//标记哪些点已经被访问
    Queue<Node> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      graph[i] = scanner.nextLine().toCharArray();
    }
    // for (int j = 0; j < graph.length; j++) {
    //   for (int k = 0; k < graph[j].length; k++) {
    //     System.out.print(graph[j][k]);
    //   }
    //   System.out.println();
    // }

    Node start = new Node(0, 0, 0);
    queue.add(start);
    while (!queue.isEmpty()) {
      Node poll = queue.poll();
      int x = poll.x;
      int y = poll.y;
      int deep = poll.depth;
      vis[x][y] = 1;//标注为已访问
      //判断是否到达终点
      if (x == m - 1 && y == n - 1) {//走到出口
        System.out.println(poll.depth);
        break;
      }
      //  加四个邻居
      if (x - 1 >= 0 && vis[x - 1][y] == 0 && graph[x - 1][y] == '.') {
        queue.add(new Node(x - 1, y, deep + 1));
      }
      if (x + 1 < m && vis[x + 1][y] == 0 && graph[x + 1][y] == '.') {
        queue.add(new Node(x + 1, y, deep + 1));
      }
      if (y - 1 >= 0 && vis[x][y - 1] == 0 && graph[x][y - 1] == '.') {
        queue.add(new Node(x, y - 1, deep + 1));
      }
      if (y + 1 < n && vis[x][y + 1] == 0 && graph[x][y + 1] == '.') {
        queue.add(new Node(x, y + 1, deep + 1));
      }
    }
  }

  static class Node {
    int x;
    int y;
    int depth;

    public Node(int x, int y, int depth) {
      this.x = x;
      this.y = y;
      this.depth = depth;
    }
  }
}
