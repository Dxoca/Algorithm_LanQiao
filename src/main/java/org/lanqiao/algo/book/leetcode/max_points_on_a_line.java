package org.lanqiao.algo.book.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 时间限制：1秒 空间限制：32768K
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 穷举法，不重不漏
 */
class Point {
  int x;
  int y;

  Point() {
    x = 0;
    y = 0;
  }

  Point(int a, int b) {
    x = a;
    y = b;
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}

public class max_points_on_a_line {
  public int maxPoints(Point[] points) {
    int n = points.length;
    if (n <= 2) return n;
    int ret = 0;
    Set<Point> maxSet = null;
    float xielv_max = 0;
    for (int i = 0; i < n; i++) {
      Map<Float, Set<Point>> map = new HashMap<Float, Set<Point>>();
      Point a = points[i];//确定第一个点
      int same = 0;
      for (int j = 0; j < n; j++) {
        if (j == i) continue;
        Point b = points[j];
        float xielv = 0;
        boolean isSame = false;
        if (a.x == b.x && a.y == b.y) { // 重叠的点
          isSame = true;
          same++;
        } else if (a.y == b.y) {
          xielv = 0.0f;
        } else if (a.x == b.x) {
          xielv = Float.POSITIVE_INFINITY;
        } else {
          xielv = (float) (a.y - b.y) / (a.x - b.x);// 斜率
        }
        if (isSame) continue;
        //第一次出现该斜率
        if (map.get(xielv) == null) {
          Set<Point> pointSet = new HashSet<>();
          pointSet.add(a);
          pointSet.add(b);
          map.put(xielv, pointSet);
        } else {
          Set<Point> pointSet = map.get(xielv);
          // pointSet.add(a);
          pointSet.add(b);
        }
      }

      int maxSize = 0;
      if (map.size() == 0) {
        same++;
      }
      for (Map.Entry<Float, Set<Point>> e : map.entrySet()) {
        if (e.getValue().size() > ret) {
          maxSize = e.getValue().size();
          // maxSet = e.getValue();
          // xielv_max = e.getKey();
        }
      }
      if (maxSize + same > ret)
        ret = maxSize + same;
    }

    // System.out.println("斜率" + xielv_max);
    // System.out.println(maxSet);
    return ret;
  }

  public static void main(String[] args) {
    Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3),
        new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(4, 0)};
    // points = new Point[]{new Point(1, 1), new Point(2, 2), new Point(1, 1), new Point(2, 2)};
    // points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(1, 1)};
    System.out.println(new max_points_on_a_line().maxPoints(points));
  }
}
