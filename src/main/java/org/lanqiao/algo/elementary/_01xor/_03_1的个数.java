package org.lanqiao.algo.elementary._01xor;

import java.util.Scanner;

public class _03_1的个数 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(Integer.toString(N, 2));

    int count = 0;
    //比对每一位
    for (int i = 0; i < 32; i++) {
      if ((N & (1 << i)) == (1 << i)) {
        count++;
      }
    }
    System.out.println(count);

    count = 0;
    for (int i = 0; i < 32; i++) {
      if (((N >>> i) & 1) == 1)
        count++;
    }
    System.out.println(count);

    count = 0;
    while (N != 0) {
      N = ((N - 1) & N);
      count++;
    }
    System.out.println(count);
  }
}
