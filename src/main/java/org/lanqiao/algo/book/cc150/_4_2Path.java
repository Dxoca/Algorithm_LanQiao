package org.lanqiao.algo.book.cc150;


import org.assertj.core.api.Assertions;

import java.util.*;

class UndirectedGraphNode {
  int label = 0;
  UndirectedGraphNode left = null;
  UndirectedGraphNode right = null;
  ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

  public UndirectedGraphNode(int label) {
    this.label = label;
  }

  public UndirectedGraphNode() {
  }

  @Override
  public String toString() {
    return "UndirectedGraphNode{" +
        "label=" + label +
        '}';
  }
}

/**
 *

 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。

 给定图中的两个结点的指针UndirectedGraphNode* a,UndirectedGraphNode* b(请不要在意数据类型，图是有向图),请返回一个bool，
 代表两点之间是否存在一条路径(a到b或b到a)。

 */
public class _4_2Path {
  public static void main(String[] args) {
    UndirectedGraphNode a = new UndirectedGraphNode( 5 );
    UndirectedGraphNode c = new UndirectedGraphNode( 6 );
    UndirectedGraphNode d = new UndirectedGraphNode( 7 );
    UndirectedGraphNode e = new UndirectedGraphNode( 1 );
    UndirectedGraphNode b = new UndirectedGraphNode( 2 );
    UndirectedGraphNode f = new UndirectedGraphNode( 3 );
    UndirectedGraphNode g = new UndirectedGraphNode( 4 );
    a.neighbors.add( c );
    c.neighbors.add( d );
    d.neighbors.add( e );
    e.neighbors.add( f );
    //b.neighbors.add( f );
    f.neighbors.add( g );
    g.neighbors.add( a );
    _4_2Path path = new _4_2Path();
    Assertions.assertThat( path.check( a, b ) ).isTrue();
    //Assertions.assertThat( path.check( b, a ) ).isFalse();
  }

  public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
    return check( a, b ) || check( b, a );
  }

  private boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
    if (a == null || b == null)
      return false;
    if (a == b)
      return true;
    Map<UndirectedGraphNode, Boolean> checkedMap = new HashMap<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    queue.offer( a );
    checkedMap.put( a, true );
    while (!queue.isEmpty()) {
      UndirectedGraphNode node = queue.poll();
      if (node.neighbors != null) {
        for (UndirectedGraphNode nei : node.neighbors) {
          if (nei == b) {
            return true;
          } else {
            Boolean checked = checkedMap.get( nei );
            if (checked == null) { // 未检查过
              queue.offer( nei );
            }
            checkedMap.put( nei, true );  // 不重复检查
          }
        }
      }
    }
    return false;
  }
}