package org.lanqiao.algo.elementary._12_graph.dfs;

import org.lanqiao.algo.elementary._12_graph.GraphNode_AL;

/*邻接表来表示图*/
public class Graph {
  public static void main(String[] args) {
    GraphNode_AL n1 = new GraphNode_AL(1);
    GraphNode_AL n2 = new GraphNode_AL(2);
    GraphNode_AL n3 = new GraphNode_AL(3);
    GraphNode_AL n4 = new GraphNode_AL(4);
    GraphNode_AL n5 = new GraphNode_AL(5);
    GraphNode_AL n6 = new GraphNode_AL(6);
    GraphNode_AL n7 = new GraphNode_AL(7);
    GraphNode_AL n8 = new GraphNode_AL(8);
    GraphNode_AL n9 = new GraphNode_AL(9);

    n1.add(n2);
    n1.add(n3);
    n1.add(n7);
    n1.add(n8);
    n1.add(n9);

    n2.add(n1);
    n2.add(n5);

    n3.add(n1);
    n3.add(n5);
    n3.add(n6);

    n4.add(n1);
    n4.add(n6);
    n5.add(n2);
    n5.add(n3);
    n6.add(n3);
    n6.add(n4);
    n7.add(n1);
    n8.add(n1);
    n9.add(n1);

    dfs(n9);


  }

  static void dfs(GraphNode_AL node) {
    System.out.println(node.val);
    node.checked = true;
    for (int i = 0; i < node.size(); i++) {
      GraphNode_AL graphNode = node.getNeighbor(i);
      if (graphNode.checked == false)
        dfs(graphNode);
    }
  }
}

