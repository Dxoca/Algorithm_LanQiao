package org.lanqiao.algo.elementary._02_01_recursion;

/**
 * 汉诺塔递归解法
 */
public class _01_TowerOfHanoi {
  public static void main(String[] args) {
    printHanoiTower(20, "A", "B", "C");
  }

  /**
   * 将N个盘子从source移动到target的路径的打印
   *
   * @param N      初始的N个从小到达的盘子，N是最大编号
   * @param from 原始柱子
   * @param to 辅助的柱子
   * @param help   目标柱子
   */
  static void printHanoiTower(int N, String from, String to, String help) {
    if (N == 1) {
      System.out.println("move " + N + " from " + from + " to " + to);
      return;
    }

    printHanoiTower(N - 1, from, help, to); // 先把前N-1个盘子挪到辅助空间上去
    System.out.println("move " + N + " from " + from + " to " + to);  // N可以顺利到达target
    printHanoiTower(N - 1, help, to, from); // 让N-1从辅助空间回到源空间上去

  }
}
