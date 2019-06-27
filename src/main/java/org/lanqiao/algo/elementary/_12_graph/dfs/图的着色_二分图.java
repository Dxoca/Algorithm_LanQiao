package org.lanqiao.algo.elementary._12_graph.dfs;

import org.lanqiao.algo.elementary._12_graph.GraphNode_AL;

/*判断是否二分图，dfs即可
* al*/
public class 图的着色_二分图 {

  static boolean dfs(MyNode node, int c) {
    node.color = c;//同时标记已访问和具体颜色
    for (int i = 0; i < node.size(); i++) {//遍历所有neighbor
      MyNode neighbor = (MyNode) node.getNeighbor(i);//具体的neighbor
      //如果相邻节点颜色一样，返回false
      if (neighbor.color == c) return false;
      //没有被染色，就染不同颜色进行递归
      if (neighbor.color == 0) {
        boolean res = dfs(neighbor, -c);
        if (!res)
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    MyNode n1 = new MyNode(1);
    MyNode n2 = new MyNode(2);
    MyNode n3 = new MyNode(3);
    MyNode n4 = new MyNode(4);

    n1.add(n2);
    n1.add(n4);

    n2.add(n1);
    n2.add(n3);

    n3.add(n2);
    n3.add(n4);

    n4.add(n1);
    n4.add(n3);

    //任意顶点都可以
    System.out.println(dfs(n1, 1));
  }

  static class MyNode extends GraphNode_AL {
    int color;

    public MyNode(int val) {
      super(val);
    }

    public MyNode(int val, int color) {
      super(val);
      this.color = color;
    }
  }
}
