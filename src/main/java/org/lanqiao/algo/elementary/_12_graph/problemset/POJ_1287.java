package org.lanqiao.algo.elementary._12_graph.problemset;


import java.util.*;

/*https://vjudge.net/problem/POJ-1287*/
public class POJ_1287 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = "";
    while (!(s = sc.nextLine()).equals("0")) {
      if (s.length() == 0) continue;
      String[] pr = s.split(" ");
      int p = Integer.parseInt(pr[0]);
      int r = Integer.parseInt(pr[1]);
      if (r > 0) {
        //对于每组数据构造一个边集
        List<Edge> list = new ArrayList<Edge>();
        for (int i = 0; i < r; i++) {
          list.add(new Edge<Integer>(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Kruskal obj = new Kruskal(list, p);
        obj.buildMST();
        System.out.println(obj.weight);
      } else if (r == 0) System.out.println(0);
      // sc.next();
      // s = sc.nextLine();
    }
  }

  private static class Kruskal {
    private final List<Edge> edgeList;
    private final int n;//总顶点数
    private Map pntAndNode = new HashMap();
    public int weight;

    // public Set<Edge> getT() {
    //   return T;
    // }

    // private Set<Edge> T = new HashSet<Edge>();//生成树的边集

    public Kruskal(List<Edge> edgeList, int n) {
      this.edgeList = edgeList;
      for (Edge edge : edgeList) {
        pntAndNode.put(edge.getStart(), new UnionFind.UFNode());
        pntAndNode.put(edge.getEnd(), new UnionFind.UFNode());
      }
      this.n = n;
    }


    /*构建MST的核心方法*/
    private void buildMST() {
      int k = 0;
      Collections.sort(edgeList);//排序
      for (Edge e : edgeList) {
        UnionFind.UFNode x = (UnionFind.UFNode) pntAndNode.get(e.getStart());
        UnionFind.UFNode y = (UnionFind.UFNode) pntAndNode.get(e.getEnd());
        if (UnionFind.find(x) == UnionFind.find(y))
          continue;

        // points.add(e.getStart());
        // points.add(e.getEnd());
        UnionFind.union(x, y);
        //确认过了，就把边都加入
        // T.add(e);
        k++;//有效边的数量+1
        weight += e.distance;
        if (k == n - 1) {
          // Set s = new HashSet();
          // for (Edge ee:
          //      T) {
          //   s.add(ee.getStart());
          //   s.add(ee.getEnd());
          // }
          // Assertions.assertThat(s.size()).isEqualTo(50);
          return;//生成树的边数==总顶点数-1 =》 所有点都已经连接
        }
      }
    }

  }

  private static class Edge<T> implements Comparable<Edge> {
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

  static class UnionFind {

    public static UFNode find(UFNode x) {
      UFNode p = x;
      Set<UFNode> path = new HashSet<UFNode>();
      //记录向上追溯的路径上的点
      while (p.parent != null) {
        path.add(p);
        p = p.parent;
      }
      //这些点的parent全部指向这个集的代表
      for (UFNode ppp : path) {
        ppp.parent = p;
      }
      return p;

    }

    public static void union(UFNode x, UFNode y) {
      find(y).parent = find(x);
    }

    public static class UFNode {
      UFNode parent;
    }
  }
}
