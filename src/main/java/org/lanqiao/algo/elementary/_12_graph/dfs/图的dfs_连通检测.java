package org.lanqiao.algo.elementary._12_graph.dfs;

import java.util.Scanner;

/*给定一个方阵，定义连通：上下左右相邻，并且值相同。
可以想象成一张地图，不同的区域被涂以不同颜色。
输入：
整数N, (N<50)表示矩阵的行列数
接下来N行，每行N个字符，代表方阵中的元素
接下来一个整数M，(M<1000)表示询问数
接下来M行，每行代表一个询问，
格式为4个整数，y1,x1,y2,x2，
表示询问(第y1行,第x1列) 与 (第y2行,第x2列) 是否连通。
连通输出true，否则false

例如：
10
0010000000
0011100000
0000111110
0001100010
1111010010
0000010010
0000010011
0111111000
0000010000
0000000000
3
0 0 9 9
0 2 6 8
4 4 4 6

程序应该输出：
false
true
true*/
public class 图的dfs_连通检测 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();
    char[][] graph = new char[N][N];
    for (int i = 0; i < N; i++) {
      graph[i] = scanner.nextLine().toCharArray();
    }
    int M = scanner.nextInt();
    int[][] query = new int[M][4];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < 4; j++) {
        query[i][j] = scanner.nextInt();
      }
    }
    // M个起点和终点
    for (int i = 0; i < M; i++) {
      //对每个起点和终点，检查是否连通
      boolean ok = check(graph, new int[N][N], query[i]);
      System.out.println(ok);
    }
  }

  /**
   * 检查两个坐标点在这个图中是否连通
   * @param graph 原始图
   * @param label 标记
   * @param points 起点和终点的坐标 x1 y1 x2 y2
   * @return
   */
  private static boolean check(char[][] graph, int[][] label, int[] points) {
    int x1 = points[0];
    int y1 = points[1];
    int x2 = points[2];
    int y2 = points[3];
    //起点和终点重合了，就可以返回true
    if (x1 == x2 && y1 == y2) {
      return true;
    }

    int value = graph[x1][y1];
    boolean f1 = false;
    boolean f2 = false;
    boolean f3 = false;
    boolean f4 = false;
    //往左走，1.不能走出去，2.左边的位置没有被访问过，3.左边位置上的值要和现在的值相同
    if (x1 - 1 >= 0 && label[x1 - 1][y1] == 0 && graph[x1 - 1][y1] == value) {
      label[x1 - 1][y1] = 1; // 坐标的位置标记为已访问
      points[0] = x1 - 1; // 把左边的点作为新起点，递归
      f1 = check(graph, label, points);
      //回溯
      label[x1 - 1][y1] = 0;
      points[0] = x1;
    }
    //往右走
    if (x1 + 1 < graph.length && label[x1 + 1][y1] == 0 && graph[x1 + 1][y1] == value) {
      label[x1 + 1][y1] = 1;
      points[0] = x1 + 1;
      f2 = check(graph, label, points);
      label[x1 + 1][y1] = 0;
      points[0] = x1;
    }
    //往上走
    if (y1 - 1 >= 0 && label[x1][y1 - 1] == 0 && graph[x1][y1 - 1] == value) {
      label[x1][y1 - 1] = 1;
      points[1] = y1 - 1;
      f3 = check(graph, label, points);
      label[x1][y1 - 1] = 0;
      points[1] = y1;
    }
    //往下走
    if (y1 + 1 < graph.length && label[x1][y1 + 1] == 0 && graph[x1][y1 + 1] == value) {
      label[x1][y1 + 1] = 1;
      points[1] = y1 + 1;
      f4 = check(graph, label, points);
      label[x1][y1 + 1] = 0;
      points[1] = y1;
    }
    return f1 || f2 || f3 || f4;
  }
}
