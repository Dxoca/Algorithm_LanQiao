package org.lanqiao.algo.elementary._12_graph;

import java.util.ArrayList;
import java.util.List;

/*邻接表*/
public class GraphNode_AL {
  public int val;
  private List<GraphNode_AL> neighbors;//邻居

  public boolean checked = false;

  public GraphNode_AL(int val) {
    this.val = val;
  }

  public GraphNode_AL getNeighbor(int i) {
    return neighbors.get(i);
  }

  public void add(GraphNode_AL node) {
    if (this.neighbors == null)
      this.neighbors = new ArrayList<>();
    this.neighbors.add(node);
  }

  public int size() {
    return this.neighbors.size();
  }
}
