package org.lanqiao.algo.book.cc150;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 第一种为直接收养所有动物中最早进入收容所的，
 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。

 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式(最早)，
 若为1，则指定收养狗，若为-1则指定收养猫。
 请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 测试样例：

 [[1,1],[1,-1],[2,0],[2,-1]]

 返回：[1,-1]

 * @author zhengwei
 */
public class _3_7CatDogAsylum {
  private static class Animal {
    int type;
    int time;
    static int timeline;// 全局变量，记录动物的时间点

    public Animal(int typeNumber) {
      this.type = typeNumber;
      this.time = timeline++;
    }
  }

  public ArrayList<Integer> asylum(int[][] ope) {
    ArrayList<Integer> res = new ArrayList<>();

    Queue<Animal> cats = new LinkedList<>();
    Queue<Animal> dogs = new LinkedList<>();
    for (int[] row : ope) {
      int op = row[0];
      int typeNumber = row[1];
      if (op == 1) {//增加
        if (typeNumber > 0) {
          dogs.add(new Animal(typeNumber));
        }
        if (typeNumber < 0) {
          cats.add(new Animal(typeNumber));
        }
      } else if (op == 2) {//减少
        if (typeNumber == 0) {//从两个队列中选timeline最小的
          if ((!dogs.isEmpty()) && (cats.isEmpty() || dogs.peek().time < cats.peek().time)) {
            res.add(dogs.poll().type);
          }
          if ((!cats.isEmpty()) && (dogs.isEmpty() || dogs.peek().time > cats.peek().time)) {
            res.add(cats.poll().type);
          }
        } else {//用户指定了类型
          if (typeNumber == 1 && !dogs.isEmpty()) {
            res.add(dogs.poll().type);
          }
          if (typeNumber == -1 && !cats.isEmpty()) {
            res.add(cats.poll().type);
          }
        }
      } else {
        break;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _3_7CatDogAsylum obj = new _3_7CatDogAsylum();
    int[][] data = {{1, 1}, {1, -1}, {1, 0}, {1, -5}, {2, 0}, {2, -1}, {2, 0}};
    System.out.println(obj.asylum(data));
    Assertions.assertThat(obj.asylum(data).toString().trim()).isEqualTo("[1, -1, -5]");
  }
}