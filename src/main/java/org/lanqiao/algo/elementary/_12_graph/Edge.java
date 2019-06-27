package org.lanqiao.algo.elementary._12_graph;

/**
 * 边 的封装
 * 边集可以用来表示图
 */
public class Edge<T> implements Comparable<Edge> {
  private T start;
  private T end;
  private int distance;

  public Edge(T start, T end, int distance) {
    this.start = start;
    this.end = end;
    this.distance = distance;
  }

  public T getStart() {
    return start;
  }

  public void setStart(T start) {
    this.start = start;
  }

  public T getEnd() {
    return end;
  }

  public void setEnd(T end) {
    this.end = end;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return start + "->" + end + ":" + distance;
  }

  @Override
  public int compareTo(Edge obj) {
    int targetDis = obj.getDistance();
    return distance > targetDis ? 1 : (distance == targetDis ? 0 : -1);
  }
}
