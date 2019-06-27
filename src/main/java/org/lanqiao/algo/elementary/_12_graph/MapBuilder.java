package org.lanqiao.algo.elementary._12_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapBuilder {
  public List<Edge> build() {
    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge("1", "2", 4));
    edges.add(new Edge("1", "3", -1));
    edges.add(new Edge("2", "3", 3));
    edges.add(new Edge("2", "4", 5));
    edges.add(new Edge("4", "5", 10));
    // Collections.sort(edges);
    return edges;
  }

  public int getPointNum() {
    return 5;
  }

  public List<Edge> build1() {
    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge("1", "2", 4));
    edges.add(new Edge("1", "3", -1));
    edges.add(new Edge("2", "3", 3));
    edges.add(new Edge("2", "4", 5));
    edges.add(new Edge("4", "5", 10));
    edges.add(new Edge("0", "2", 10));
    edges.add(new Edge("0", "3", 10));
    edges.add(new Edge("0", "4", 1));
    edges.add(new Edge("0", "5", 1));

    Collections.sort(edges);
    return edges;
  }

  public int getPointNum1() {
    return 6;
  }
}
