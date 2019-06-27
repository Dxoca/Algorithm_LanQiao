package org.lanqiao.algo.elementary._01xor;

import org.lanqiao.algo.util.Util;

import java.util.Random;

public class _01唯一成对的数 {
  public static void main(String[] args) {
    int N = 1001;
    int[] arr = new int[N];
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = i + 1;
    }
    //最后一个数，是随机数
    arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;
    //随机下标
    int index = new Random().nextInt(N);
    Util.swap(arr, index, arr.length - 1);
    Util.print(arr);
    int x1 = 0;
    for (int i = 1; i <= N - 1; i++) {
      x1 = (x1 ^ i);
    }
    for (int i = 0; i < N; i++) {
      x1 = x1 ^ arr[i];
    }
    System.out.println(x1);

    System.out.println("==========");
    int[] helper = new int[N];
    for (int i = 0; i < N; i++) {
      helper[arr[i]]++;
    }
    for (int i = 0; i < N; i++) {
      if (helper[i] == 2) {
        System.out.println(i);
        break;
      }
    }
  }
}
