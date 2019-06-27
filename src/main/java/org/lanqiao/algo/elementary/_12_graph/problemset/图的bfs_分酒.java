package org.lanqiao.algo.elementary._12_graph.problemset;

import java.util.*;

/**
 有4个红酒瓶子，它们的容量分别是：9升, 7升, 4升, 2升
 开始的状态是 [9,0,0,0]，也就是说：第一个瓶子满着，其它的都空着。

 允许把酒从一个瓶子倒入另一个瓶子，但只能把一个瓶子倒满或把一个瓶子倒空，不能有中间状态。
 这样的一次倒酒动作称为1次操作。

 假设瓶子的容量和初始状态不变，对于给定的目标状态，至少需要多少次操作才能实现？
 本题就是要求你编程实现最小操作次数的计算。

 输入：最终状态（空格分隔）
 输出：最小操作次数（如无法实现，则输出-1）

 例如：
 输入：
 9 0 0 0
 应该输出：
 0

 输入：
 6 0 0 3
 应该输出：
 -1

 输入：
 7 2 0 0
 应该输出：
 2
 */

//更多的情况，节点不是很明显，多是一种“状态”
//瓶子倒来倒去...状态肯定是有限的

public class 图的bfs_分酒 {
  static Set<Node> set = new HashSet<>();
  static int[] v = {9, 7, 4, 2};
  static Queue<Node> queue = new LinkedList<>();
  static Node beginNode = new Node("9,0,0,0", 0);
  static Node finalNode;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //接受四个整数
    String finalState = "";
    finalState += scanner.nextInt() + ",";
    finalState += scanner.nextInt() + ",";
    finalState += scanner.nextInt() + ",";
    finalState += scanner.nextInt();
    finalNode = new Node(finalState);
    add(queue, beginNode);
    int res = bfs();
    System.out.println(res);
  }

  private static void add(Queue<Node> queue, Node node) {
    if (!set.contains(node)) {
      set.add(node);
      queue.add(node);
    }
  }

  private static int bfs() {
    while (!queue.isEmpty()) {
      Node now = queue.poll();//弹出一个
      //如果和目标吻合，则返回
      if (now.equals(finalNode)) {
        return now.depth;
      }
      //把neighbors（一步操作得到的下一种状态）加入队列
      //先把每个瓶子里面的量得到
      int[] state = now.getState();
      //i是往外倒的
      for (int i = 0; i < state.length; i++) {
        if (state[i] > 0) {//有酒,如2 7 0 0
          //j是接收的
          for (int j = 0; j < state.length; j++) {
            if (j == i) continue;
            //把i倒完的条件
            int j_KongJian = v[j] - state[j];
            if (j_KongJian >= state[i]) {
              //形成新状态
              int temp = state[i];
              state[i] = 0;
              state[j] += temp;
              add(queue, new Node(intArr2String(state), now.depth + 1));
              //恢复
              state[i] = temp;
              state[j] -= state[i];
            }

            //把j倒满，j有空间，且i能倒完
            if (j_KongJian > 0 && state[i] >= j_KongJian) {
              int temp = state[i];
              state[i] -= j_KongJian;
              state[j] += j_KongJian;
              add(queue, new Node(intArr2String(state), now.depth + 1));
              //  恢复
              state[i] = temp;
              state[j] -= j_KongJian;
            }
          }
        }
      }
    }
    return -1;
  }

  private static String intArr2String(int[] state) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < state.length; i++) {
      sb.append(state[i]).append(",");
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }

  static class Node {
    String val;//9,0,0,0
    int depth;//深度，或者说到达这个状态需要的操作次数

    public Node(String val) {
      this.val = val;
    }

    public Node(String val, int depth) {
      this.val = val;
      this.depth = depth;
    }

    //把状态字符串转成四个杯子的存量，方便运算
    public int[] getState() {
      String[] arr = val.split(",");
      int[] res = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
        res[i] = Integer.parseInt(arr[i]);
      }
      return res;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Node node = (Node) o;

      return val.equals(node.val);
    }

    @Override
    public int hashCode() {
      return val.hashCode();
    }
  }
}
