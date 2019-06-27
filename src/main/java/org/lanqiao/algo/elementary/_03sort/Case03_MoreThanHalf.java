package org.lanqiao.algo.elementary._03sort;

import java.util.Arrays;

//数组中出现次数超过半数的元素
//解法1：排序后返回arr[N/2],NLg(N)
//解法2：hash统计
//解法3：顺序统计,O(N)，限制：需要改动数组的内容
//解法4：不同的数，进行消除
public class Case03_MoreThanHalf {

  static void solve1(int[] arr) {
    Arrays.sort(arr);
    System.out.println(arr[arr.length / 2]);
  }

  static void solve3(int[] arr) {
    int res = Case02_OrderStatistic.selectK(arr, 0, arr.length - 1, arr.length / 2);
    System.out.println(res);
  }
  /*不同的数，进行消除，O(N)*/
  public static void solve4(int[] arr) {
    //候选数，先定位第一个元素
    int candidate = arr[0];
    //出现的次数
    int nTimes = 1;
    //扫描数组
    for (int i = 1; i < arr.length; i++) {
      //两两消减为0，应该把现在的元素作为候选值
      if (nTimes == 0) {
        candidate = arr[i];
        nTimes = 1;
        continue;
      }
      //遇到和候选值相同的，次数加1
      if (arr[i] == candidate)
        nTimes++;
        //不同的数，进行消减
      else
        nTimes--;
    }
    System.out.println(candidate);
  }

  //变化，出现次数恰好为个数的一半，求出这个数
  /*
  * 关于加强版水王的题我有个想法可以扫描一遍数组就解决问题：
    水王占总数的一半，说明总数必为偶数；
    不失一般性，假设隔一个数就是水王的id，两两不同最后一定会消减为0
    水王可能是最后一个元素，每次扫描的时候，多一个动作，和最后一个元素做比较，单独计数，计数恰好等于一半
    如果不是，计数不足一半，那么去掉最后一个元素，水王就是留下的那个candidate*/
  public static void solve5(int[] arr) {
    int candidate = arr[0];
    int nTimes = 0;
    int countOfLast = 0;//统计最后这个元素出现的次数
    int N = arr.length;
    for (int i = 0; i < N; i++) {
      //增加和最后一个元素比较的步骤
      if (arr[i] == arr[N - 1])
        countOfLast++;

      if (nTimes == 0) {
        candidate = arr[i];
        nTimes = 1;
        continue;
      }
      if (arr[i] == candidate)
        nTimes++;
      else
        nTimes--;
    }
    //最后一个元素出现次数是n/2
    if (countOfLast == N / 2)
      System.out.println(arr[N - 1]);
    else
      System.out.println(candidate);
  }

  public static void main(String[] args) {
    solve3(new int[]{0, 1, 2, 1, 1});
  }
}
