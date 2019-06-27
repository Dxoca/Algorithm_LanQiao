package org.lanqiao.algo.elementary._12_graph.dfs;

/**
 * 输入一个m行n列的字符矩阵，统计字符“@”组成多少个八连块。
 *  如果两个字符“@”所在的格子相邻（横、竖或者对角线方向），就说它们属于同一个八连块。
 *
 *  分析：图的dfs
 */
public class 图的dfs_FloodFill {
  private static char[][] data = {
      "*@@*@".toCharArray(),
      "**@*@".toCharArray(),
      "****@".toCharArray(),
      "@@@*@".toCharArray(),
      "@@**@".toCharArray(),
  };
  //记录区块数
  private static int cnt;
  //访问记录
  // private static int[][] vis = new int[data.length][data[0].length];

  private static void dfs(int r, int c) {
    // 设计出口
    //超出边界了
    if (r < 0 || r >= data.length || c < 0 || c >= data[0].length) return;
    //不是@
    if (data[r][c] == '*') return;
    //已经扫描过了，这是深度搜索必须考虑到的点
    // if (vis[r][c] == 1) return;

    //标记为已访问
    // vis[r][c] = 1;
    data[r][c] = '*';
    // 八个方向去探测，继续搜索
    dfs(r + 1, c);
    dfs(r - 1, c);
    dfs(r, c + 1);
    dfs(r, c - 1);
    dfs(r + 1, c + 1);
    dfs(r + 1, c - 1);
    dfs(r - 1, c - 1);
    dfs(r - 1, c + 1);
  }

  public static void main(String[] args) {
    //遍历每个字符
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[0].length; j++) {
        // if (vis[i][j] == 0 && data[i][j] == '@')
        //找到@就开始深搜，深搜的过程就是把@变为*的过程
        if (data[i][j] == '@') {
          dfs(i, j);//当深搜完成，说明当前字符所在的八连块全部被修改为*，应该块的计数+1，并寻找下一个@
          ++cnt;
        }
      }
    }
    System.out.println(cnt);
  }
}

