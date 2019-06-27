package org.lanqiao.algo.book.other.recursion;

/**
 * 汉诺塔递归解法
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        new TowerOfHanoi().printHanoiTower(3, "A", "C", "B");
    }

    /**
     * 将N个盘子从source移动到target的路径的打印
     *
     * @param N      初始的N个从小到达的盘子，N是最大编号
     * @param source 原始柱子
     * @param target 辅助的柱子
     * @param help   目标柱子
     */
    void printHanoiTower(int N, String source, String target, String help) {
        if (N == 1) {
            System.out.println("move " + N + " from " + source + " to " + target);
        } else {
            printHanoiTower(N - 1, source, help, target); // 先把前N-1个盘子挪到辅助空间上去
            System.out.println("move " + N + " from " + source + " to " + target);  // N可以顺利到达target
            printHanoiTower(N - 1, help, target, source); // 让N-1从辅助空间回到源空间上去
        }
    }
}
