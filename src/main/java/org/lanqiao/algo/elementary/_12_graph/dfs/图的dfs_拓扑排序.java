package org.lanqiao.algo.elementary._12_graph.dfs;

/*具有检测是否有环的功能
* am*/
public class 图的dfs_拓扑排序 {
  //顶点数
  static final int n = 4;
  //顶点内容
  static String[] v = {"a", "b", "c", "d"};
  //有向图的邻接矩阵表示法
  static int[][] graph = {
      {0, 1, 0, 0},
      {0, 0, 0, 0},
      {0, 1, 0, 0},
      {0, 0, 1, 0},
  };
  //标记顶点访问状态，1：已经访问并返回，0：从未被方位，-1：正在递归访问还未退出
  static int[] vis = new int[n];
  //拓扑排序结果
  static int[] topo = new int[n];
  //标记topo数组的哪一位被改写
  static int t = n;

  public static void main(String[] args) {
    //对所有顶点进行迭代
    for (int i = 0; i < n; i++) {
      //如果被访问，则跳过
      if (vis[i] == 1) continue;

      boolean bool = dfs(i);// 是否有拓扑序
      if (!bool) {
        System.out.println(false);
        return;
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.println(v[topo[i]]);
    }
  }

  private static boolean dfs(int i) {
    vis[i] = -1;
    //遍历所有顶点
    for (int j = 0; j < n; j++) {
      if (graph[i][j] > 0) {//当前关注顶点i到顶点j有出度
        //此处，关于j顶点的递归还没有退出，前驱的状态是-1，后继的状态也是-1，说明在此次递归的链路上早就路过了j，现在是第二次路过j，
        // 一次递归链路两次经过j，只有一种情况，形成了环
        if (vis[j] < 0) return false;
        //j没被访问过，执行递归
        if (vis[j] == 0 && dfs(j) == false) return false;
      }
    }
    //整个递归是按照出度方向来的，所以上面的循环+递归走到尽头时，i没有出度，没有出度的点可以认为是最大的点（之一）
    topo[--t] = i;
    vis[i] = 1;
    return true;
  }
}
